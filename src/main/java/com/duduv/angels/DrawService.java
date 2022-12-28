package com.duduv.angels;

import com.duduv.angels.model.AngelConfig;
import com.duduv.angels.model.Draw;
import com.duduv.angels.model.Game;
import com.duduv.angels.model.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * angels : Created by Philippe on 27-12-22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DrawService {


    private final AngelConfig angelConfig;
    private final EmailService emailService;

    public Game collectGame(String name) {
        return angelConfig.getGames().stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }

    public void draw(String name) {
        Game game = collectGame(name);
        Draw draw = selectPlayer(game);
        draw.setGame(game);

        log.info("draw: "+ draw);

        //send mail
        sendMailPlayers(draw);
        sendMailSecretKeeper(draw);
        log.info("mail sent", game);
    }

    private void sendMailPlayers(Draw draw) {
        for (Player player : draw.getDraws().keySet()) {
            if (player.getEmail().equals("philippe.dvg@gmail.com")) {
                Player target = draw.getDraws().get(player);
                Map<String, Object> context = new HashMap<>();
                context.put("name", player.getName());
                context.put("protected", target.getName());
                context.put("drawName", draw.getName());
                emailService.sendSimpleMessage(player.getEmail(), draw.getGame().getMailSubject(), "msg-template.ftlh", context);
            }
        }
    }

    private void sendMailSecretKeeper(Draw draw) {
        String secretKeeperEmail = angelConfig.getSecretKeeperEmail();
        Map<String, Object> context = new HashMap<>();
        context.put("name", angelConfig.getSecretKeeperName());
        context.put("gameName", draw.getGame().getName());
        context.put("drawName", draw.getName());
        context.put("list", draw.getDraws());
        emailService.sendSimpleMessage(secretKeeperEmail, angelConfig.getSecretKeeperMailSubject(), "boss-msg-template.ftlh", context);
    }

    private Draw selectPlayer(Game game) {
        try {
            Draw draw = new Draw();
            draw.setName(game.getName() + " " + new Date());
            for (Player player : game.getPlayers()) {
                List<Player> candidates = game.getPlayers().stream()
                        .filter(p -> !p.getName().equals(player.getName()) && !p.getFamilyId().equals(player.getFamilyId()))
                        .filter(p -> !draw.getAllTarget().contains(p))
                        .toList();
                Player target = candidates.get(RandomUtils.nextInt(0, candidates.size()));
                draw.getDraws().put(player, target);
            }
            return draw;
        } catch (IndexOutOfBoundsException e) {
            return selectPlayer(game);
        }
    }


}
