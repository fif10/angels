<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Les anges ont été tirés</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

    <!-- use the font -->
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            font-size: 48px;
        }
    </style>
</head>
<body style="margin: 0; padding: 0;">

<table align="center" border="0" cellpadding="0" cellspacing="0" width="600" style="border-collapse: collapse;">
    <tr>
        <td align="center" bgcolor="#78ab46" style="padding: 40px 0 30px 0;">
            <img src="cid:logo.png" alt="les anges logo" style="display: block;"/>
        </td>
    </tr>
    <tr>
        <td bgcolor="#eaeaea" style="padding: 40px 30px 40px 30px;">
            <p>Bonjour ${name},</p>
            <p></p>
            <p>Tu es le "secret keeper" pour les anges ${gameName}</p>
            <p></p>
            <p>Garde ce mail très précieusement !!! Tu es le/la seul(e) a le recevoir. </p>
            <p>Il est bien sûr interdit de le communiquer, même sous la torture, ou pot de vin confortable</p>
            <p></p>
            <p></p>
            <p>Voici la liste complete a utiliser en cas de soucis : </p>
            <table>
                <tr>
                    <td>Ange</td>
                    <td>Protégé</td>
                </tr>
                <#list list as key, value>
                    <tr>
                        <td> ${key.name}</td>
                        <td> ${value.name}</td>
                    </tr>
                </#list>
            </table>

            <p></p>
            <p>Bises</p>
            <p><i>Ref tirage - ${drawName}</i></p>
        </td>
    </tr>
</table>
</body>
</html>