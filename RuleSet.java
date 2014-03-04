/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priebe.lsystems;

import java.util.Random;

/**
 *
 * @author James
 */
// specifies a symbol, its rules, and probability for each rule (for stochastic systems)
public class RuleSet {

    private String symbol;
    private String[] rules;
    private double[] probabilities;

    // deterministic constructor
    RuleSet(String symbol, String rule) {
        this.symbol = symbol;
        this.rules = new String[]{rule};
        this.probabilities = new double[]{1.0};

    }

    // stochastic constructor
    RuleSet(String symbol, String[] rules, double[] probs) {

        this.symbol = symbol;
        this.rules = rules;
        this.probabilities = probs;

    }

    public String getSymbol() {
        return symbol;
    }

    // randomly selects a rule
    public String getRule() {

        Random r = new Random();
        double d = r.nextDouble();
        double lowerBound = 0.0;

        for (int i = 0; i < probabilities.length; i++) {

            if ((d > lowerBound) && (d <= probabilities[i] + lowerBound)) {

                //System.out.println("random: " + d + " lower bound: " + lowerBound + " rule chosen: " + rules[i]);
                return rules[i];
            }

            lowerBound = lowerBound + probabilities[i];

        }

        return rules[0];

    }

    public String getAllRules() {

        String r = "";
        for (String s : rules) {
            r += (s + "  ");
        }
        return r;
    }

    // adjusts probabilities of preexisting rules to total 100%
    // probability between 0.0 and 1.0
    public void addRule(String rule, double probability) {

        double newTotal = 1.0 - probability;
        double[] newProbabilities = new double[probabilities.length + 1];
        String[] newRules = new String[rules.length + 1];

        for (int i = 0; i < probabilities.length; i++) {
            probabilities[i] = probabilities[i] * (newTotal / 1.0);
            newProbabilities[i] = probabilities[i];
            newRules[i] = rules[i];
        }
        newRules[rules.length] = rule;
        newProbabilities[probabilities.length] = probability;

        this.rules = newRules;
        this.probabilities = newProbabilities;
    }

}
