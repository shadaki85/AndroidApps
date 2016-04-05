package com.example.svilupposw.hello_world;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;

/**
 * Created by svilupposw on 14/03/16.
 */
public class SharedPrefs extends Application{

    /*private Set<String> usernames;
    private Set<String> passwords;
    private Set<String> emails;
    private Set<String> descriptions;
    */
    private String[] usernames = {"Stefano","Simona","Luca","Giacomo","Sergio","Antonio","Filippo","Massimo","Matteo","Paolo"};
    private String[] passwords = {"stefano","simona","luca","giacomo","sergio","antonio","filippo","massimo","matteo","paolo"};
    @Override
    public void onCreate() {
        /*usernames.add("Stefano");usernames.add("Simona");usernames.add("Luca");usernames.add("Giacomo");usernames.add("Sergio");usernames.add("Antonio");usernames.add("Filippo");usernames.add("Massimo");usernames.add("Matteo");usernames.add("Paolo");
        passwords.add("stefano");passwords.add("simona");passwords.add("luca");passwords.add("giacomo");passwords.add("sergio");passwords.add("antonio");passwords.add("filippo");passwords.add("massimo");passwords.add("matteo");passwords.add("paolo");
        emails.add("stefano@gmail.com");emails.add("simona@gmail.com");emails.add("luca@gmail.com");emails.add("giacomo@gmail.com");emails.add("sergio@gmail.com");emails.add("antonio@gmail.com");emails.add("filippo@gmail.com");emails.add("massimo@gmail.com");emails.add("matteo@gmail.com");emails.add("paolo@gmail.com");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        descriptions.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut at est lorem. Nam lobortis elit sit amet magna euismod eleifend. Cras ultrices sodales velit nec ullamcorper. Aliquam erat volutpat. Phasellus eros dolor, gravida vitae tellus ut, consectetur vehicula mauris. Ut massa massa, pretium et ultrices a, malesuada sit amet sapien. Aenean aliquam ligula tellus, quis blandit elit blandit id. Suspendisse porta maximus aliquam. Sed viverra, erat eget auctor dignissim, nulla turpis feugiat eros, tincidunt mattis nisl mi eu nulla. Phasellus egestas mauris ante, eu cursus nisi sollicitudin at. Praesent id nulla nec nisl finibus cursus ut id ex. Donec risus est, sagittis vel vehicula posuere, finibus sit amet lectus. Sed feugiat posuere viverra. Nulla facilisi.");
        */

        super.onCreate();
        SharedPreferences sharedpref = getApplicationContext().getSharedPreferences(getString(R.string.pref_file_key) , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        //editor.putStringSet("username",usernames);
        //editor.putStringSet("passwords",passwords);
        //editor.putStringSet("emails",emails);
        //editor.putStringSet("descriptions",descriptions);

        for(String username: usernames)
        {
            editor.putString(username,username);
        }
        for(String password: passwords)
        {
            editor.putString(password,password);
        }
        /*for(String email: emails)
        {
            editor.putString(email,email);
        }
        for(String description: descriptions)
        {
            editor.putString(description,description);
        }*/
        editor.commit();
    }
}
