import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import javax.security.auth.login.LoginExpection;

import net.dv8tion.jda.api.JDABuilderl;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdpter;


public class LEV extends ListenerAdpter{

private static final string Token = "Token discord bot"
private static final String GUILD_ID = "Guild ID"
private static final string CHANNEL_ID = "CHANNEL ID"
private static final LocalTime OPEN_TIME = LocalTime.of(17, 0);
private static final LocalTime CLOSE_TIME = LocalTime.of(3, 0);

public static void main(String[] args) throws LoginExpection {
JDABuilderl.createDefault(Token)
    .addEventListeners(new LEV())
    .build();
}
@override
public void onReady(ReadyEvent event) {

Guild guild = event.getJDA().getGuildById(GUILD_ID);
if (guild != null){

    timer timer = new timer();
    timer.schedual(new TimerTask()){
        @override
        public void run() {
            LocalTime currentTime = LocalTime.now();
            TextChannel channel = guild.getTextChannelById(CHANNEL_ID);
            if ( channel != null){
                if (currentTime.isAfter(OPEN_TIME) && currentTime.isBefore(CLOSE_TIME))
                    if(!channel.canTalk()){
                        channel.createPremissionOverride(guild.getPublicRole())
                        .setAllow(net.dv8tion.jda.api.Permission.MESSAGE_WRITE)
                        .queue();

                    }
            } (0, 60000);
        }

    }
}






}





}