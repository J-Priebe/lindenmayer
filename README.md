Java L-Systems
http://en.wikipedia.org/wiki/L-system

L-Systems share the same idea as formal languages, but transformations are applied in parallel. They can be used to generate fractals. This implementation aims to provide a simples means of defining languages and a way to draw their corresponding fractals.

The language is defined by one or more RuleSets, each of which maps a symbol to one or more rules (each rule has a probabilility of being applied). Any symbols appearing in the initial axiom that do not have a corresponding RuleSet are treated as constants, i.e,  C --> C

