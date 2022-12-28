# Angels / Les anges

![image](src/main/resources/logo.png)



## Context
In my family, we have every year, a gift :gift: (homemade) to offer to one random other member, and this has to be secret. 
We call this '**les anges**' (angels in English)
In order to automate this choice, the send of the choice, and avoid the gift to  a partner (husband/wife), this basic application was created
It chooses a member (**player**) and send an email to each member. 
It also sends the complete list to the "secret-keeper" for safety 

## Implementation 
This spring boot application will do a random draw :game_die: among the players in each game. 
The person (receiver) drawn for each player cannot be in the same familyId
The members is stored currently in spring boot config
It can have several games (containing the players) and the name of the game is the  parameter of the application. (default is adults)

The mail :envelope: is prepared with `freeMarker` and sent to each player.
A special mail is sent to the secret keeper.

## Usage 
- Configure the player in the `application.yml` file 
- Configure also the mail account (smtp)
- Update if needed the mail template
    - boss-msg-template.ftlh, for the secret keeper
    - msg-template.ftlh for the players
- Update if you want the `logo.png` (mail logo)
 - compile by running :  `mvn clean install` 
- Run the application with the game name as argument

## Licence
The licence of this application is a 'oneFeetJumpLicence' meaning that you have to jump 3 times on one feet before to be allowed to use it. 
In case you don't have feet, the licence is free of usage.