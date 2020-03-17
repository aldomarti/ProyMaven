package net.kiranatos.examples.v10lang;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChangeLanguage {
    
    public ChangeLanguage(Locale currentLocale) {
        System.out.println("\n\n\t currentLocale = " + currentLocale.toString());
        System.out.println();
        ResourceBundle bundle = ResourceBundle.getBundle("net/kiranatos/examples/v10/ChoiceBundle", currentLocale);
        MessageFormat messageFormat = new MessageFormat("");
        messageFormat.setLocale(currentLocale);
        double[] fileLimits = {0, 1, 2};
        String[] fileStrings = {
            bundle.getString("noFiles"),
            bundle.getString("oneFile"),
            bundle.getString("multipleFiles")
        };
        ChoiceFormat choiceForm = new ChoiceFormat(fileLimits, fileStrings);
        String pattern = bundle.getString("pattern");
        Format[] formats = {choiceForm, null, NumberFormat.getInstance()};
        messageFormat.applyPattern(pattern);
        messageFormat.setFormats(formats);
        Object[] messageArguments = {null, "desk", null};
        for (int numFiles = 0; numFiles < 4; numFiles++) {
            messageArguments[0] = new Integer(numFiles);
            messageArguments[2] = new Integer(numFiles);
            String result = messageFormat.format(messageArguments);
            System.out.println(result);
        }
    }

    public static void main(String args[]){
        new ChangeLanguage(new Locale("en", "US"));
        System.out.println();
        new ChangeLanguage(new Locale("fr", "FR"));
    }    
}


/*
ChoiceBundle.properties :

noFiles = are no files
oneFile = is one file
multipleFiles = are {2} files
pattern = There {0} on {1}.

ChoiceBundle_en_US.properties :

noFiles = are no files
oneFile = is one file
multipleFiles = are {2} files
pattern = There {0} on {1}.

ChoiceBundle_fr_FR.properties :

noFiles = n' y a pas des fichiers
oneFile = y a un fichier
multipleFiles = y a {2} fichiers
pattern = Il {0} sur {1}.

output :
There are no files on desk.
There is one file on desk.
There are 2 files on desk.
There are 3 files on desk.

currentLocale = fr_FR

Il n' y a pas des fichiers sur desk.
Il y a un fichier sur desk.
Il y a 2 fichiers sur desk.
Il y a 3 fichiers sur desk.

*/