/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priebe.lsystems;

import java.util.HashMap;

/**
 *
 * @author James
 */
public class FractalTest {

    public static void main(String[] args) {

     /*   String axiom = "A";
        RuleSet a = new RuleSet("A", "AB");
        RuleSet ab = new RuleSet("B", "A");
        L_System algae = new L_System(new RuleSet[]{a, ab}, axiom);
        String[] fractal = algae.buildFractal(2);
       // System.out.println(fractal);

        String axiom2 = "0";
        RuleSet r1 = new RuleSet("1", "11");
        RuleSet r2 = new RuleSet("0", "1[0]0");
        RuleSet r3 = new RuleSet("[", "[");
        RuleSet r4 = new RuleSet("]", "]");
        
        L_System derp = new L_System(new RuleSet[]{r1,r2,r3,r4}, axiom2);
        
        String[] derpy = derp.buildFractal(5);*/
        
        RuleSet a = new RuleSet("a", new String[]{"b","c","d","e"}, new double[]{0.3,0.3,0.2,0.2});
        L_System stochastic = new L_System(new RuleSet[]{a}, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        stochastic.buildFractal(5);
    }
}
