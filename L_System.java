/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priebe.lsystems;

import java.util.HashMap;
import java.util.Random;

public class L_System {

    private String axiom;

    private String[] fractalIterations;

    // Maps a symbol to an array of rules
    private HashMap<String, RuleSet> language;

    public L_System(RuleSet[] rules, String axiom) {

        this.axiom = axiom;
        this.language = new HashMap();
        for (RuleSet s : rules) {
            language.put(s.getSymbol(), s);

        }
        printRules();

    }

    void addSymbol(String symbol, String[] rules, String probs) {

    }

    public final void printRules() {

        System.out.println("Axiom:\n" + axiom);

        System.out.println("\nSymbols and Rules: ");
        for (String key : language.keySet()) {
            System.out.println(key + " --> " + language.get(key).getAllRules());
        }
        System.out.println();
    }

    //Applies transformation to each symbol in the string
    private String applyRules(String s) {
        String post = "";
        String[] chars = s.split("(?!^)");
        for (String c : chars) {
            RuleSet r = language.get(c);
            if (r == null) {
                post += c;
            } else {
                String ns = r.getRule();
                post += ns;
            }
        }
        return post;
    }

    //n = number of iterations
    public String[] buildFractal(int n) {

        String computedFractal = axiom;

        fractalIterations = new String[n + 1];
        for (int i = 0; i <= n; i++) {

            fractalIterations[i] = computedFractal;
            System.out.println(i + ": " + computedFractal);

            computedFractal = applyRules(computedFractal);

        }
        return fractalIterations;
    }

}
