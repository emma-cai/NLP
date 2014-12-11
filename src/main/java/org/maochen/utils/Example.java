package org.maochen.utils;


import org.maochen.wordnet.Synset;
import org.maochen.wordnet.WordNetDatabase;

import java.io.IOException;

/**
 * Created by Maochen on 12/11/14.
 */
public class Example {

    public static void main(String[] args) throws IOException {
        System.setProperty("wordnet.database.dir", "/Users/Maochen/Desktop/WordNet-3.0/dict");

        String wordForm = "banana";
        //  Get the synsets containing the wrod form
        WordNetDatabase database = WordNetDatabase.getFileInstance();
        Synset[] synsets = database.getSynsets(wordForm);
        //  Display the word forms and definitions for synsets retrieved
        if (synsets.length > 0) {
            System.out.println("The following synsets contain '" +
                    wordForm + "' or a possible base form " +
                    "of that text:");
            for (int i = 0; i < synsets.length; i++) {
                System.out.println("");
                String[] wordForms = synsets[i].getWordForms();
                for (int j = 0; j < wordForms.length; j++) {
                    System.out.print((j > 0 ? ", " : "") +
                            wordForms[j]);
                }
                System.out.println(": " + synsets[i].getDefinition());
            }
        } else {
            System.err.println("No synsets exist that contain " +
                    "the word form '" + wordForm + "'");
        }

    }
}
