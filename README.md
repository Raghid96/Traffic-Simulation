# Traffic-Simulation

The main method will run a traffic simulation of a intersection


# The output of the simulation

------------- Time = 1 ----------------------
(R)<[W, W, W, W, W, W, W, W]><[W, S, W, W, S, W, W, W, S, S]> Q [W, S, W, S]

(R)<[S, ., ., ., ., ., ., .]>

------------- Time = 2 ----------------------
(R)<[W, W, W, W, W, W, W, W]><[W, S, W, W, S, W, W, W, S, S]> Q [W, S, W, S]

(G)<[S, ., ., ., ., ., ., .]>

The first line corresponds to the trafic lights beeing either (G)-green or (R)-red.

The letters inside the array gives the heading of the vehicle, either S-South or W-West.

The Q-queue array is where cars wait if both arrays are full.

Once the simulation has reached 100 steps the user can choose to quit or continue the simularion for another 100 steps.
