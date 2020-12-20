package me.smaks6.bookrules;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

public class cmd implements CommandExecutor {

    public cmd(Bookrules bookrules) {
        bookrules.getCommand("rules").setExecutor(this);
        bookrules.getCommand("bookrules").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("rules")) {
            Player p = (Player) sender;
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
            BookMeta bm = (BookMeta)book.getItemMeta();
            List<?> config = Bookrules.getInstance().getConfig().getList("rules");
            bm.setAuthor("BookRules");
            bm.setTitle("Rules");
            for (int i = 0; i < config.size(); i++) {
                String text = (String) config.get(i);
                if (text == null) {
                    continue;
                }
                bm.addPage(text);
            }
            book.setItemMeta(bm);

            p.openBook(book);

        }
        else if(cmd.getName().equalsIgnoreCase("Bookrules")){
            Player p = (Player) sender;
            Bookrules.getInstance().reloadConfig();
            p.sendMessage(ChatColor.GREEN + "Reloaded plugin Bookrules BY smaks6");
        }
        return false;
    }

}
