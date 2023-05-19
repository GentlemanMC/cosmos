package cope.cosmos.client.features.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import cope.cosmos.client.features.command.Command;
/**
 * @author linustouchtips
 * @since 08/25/2022
 */
public class FontCommand extends Command {
    public static FontCommand INSTANCE;

    public FontCommand() {
        super("Font", "Sets the client's custom font");
        INSTANCE = this;
    }

    @Override
    public void onExecute(String[] args) {

        if (args.length == 1) {

            // font to load
            String font = args[0];

            // loads a given font
            getCosmos().getFontManager().loadFont(font.endsWith(".ttf") ? font : font + ".ttf");
        }

        else {

            // unrecognized arguments exception
            getCosmos().getChatManager().sendHoverableMessage(ChatFormatting.RED + "Unrecognized Arguments!", ChatFormatting.RED + "Please enter the correct arguments for this command.");
        }
    }

    @Override
    public String getUseCase() {
        return "<font>";
    }

    @Override
    public int getArgSize() {
        return 1;
    }
}