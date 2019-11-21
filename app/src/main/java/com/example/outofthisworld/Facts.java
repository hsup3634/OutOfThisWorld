package com.example.outofthisworld;

import java.util.Random;

public class Facts {


    // this array stores all the facts that are in the "fun fact" functionality of the app
    String[] factsList = {
            "Space is completely silent due to the lack of atmosphere in the vacuum of space meaning there is no medium to travel through for sound waves.",
            "Venus is the hottest planet in the solar system with an average surface temperature of around 450 degrees celsius. ",
            "The footprints of the Apollo astronauts will remain on the Moon for at least 100 million years due to lack or wind and water to wash away the prints.",
            "The Andromeda galaxy is the closest spiral galaxy to our own Galaxy, the Milky Way.",
            "The Sun is composed of hydrogen and helium with small addition of heavier elements.",
            "The Sun is composed of hydrogen and helium with small addition of heavier elements.",
            "Solar energy is generated in the solar core. The source of this energy is nuclear fusion (nuclei of small atoms combine together to make bigger nuclei).",
            "Auroras occur only close to Earth because the charged particles from the solar wind can follow the Earth's magnetic field lines which concentrates them toward the poles.",
            "The hottest stars have their peak of radiation in blue wavelengths. Therefore they appear bluish. A red star will be cooler than the Sun (5800K), having a temperature of about 3000 K.",
            "The black hole forms when fusion stops in the core, and the energy produced can no longer hold up the gas against gravity.",
            "In a neutron star protons and electrons are combined into neutrons under enormous pressure.",
            "White dwarfs are less luminous than the Sun and close in size to the Earth, they are hotter than red giants but only as hot as blue giants.",
            "Galileo Galilei discovered the four most massive moons of Jupiter (now known as the Galilean moons) and supported the Copernican heliocentric model of the solar system.",
            "Meteoroids are objects in space that range in size from dust grains to small asteroids.",
            "When Meteoroids enter Earth’s atmosphere (or that of another planet, like Mars) at high speed and burn up, the fireballs or “shooting stars” are called meteors.",
            "When a meteoroid survives a trip through the atmosphere and hits the ground, it’s called a meteorite.",
            "Asteroids, sometimes called minor planets, are rocky, airless remnants left over from the early formation of our solar system about 4.6 billion years ago."};

    //getter to retrieve these facts
    public String getFact() {
        String fact = "";

        //this randomises the facts
        Random randomGenerator = new Random();
        //randomising the facts so they aren't in order
        int randomNumber = randomGenerator.nextInt(factsList.length);
        fact = factsList[randomNumber];
        return fact;
    }
}

//reference: this code is derived from the fun facts app: https://github.com/treehouse/android-fun-facts-github/blob/master/app/src/main/java/com/teamtreehouse/funfacts/FactBook.java
