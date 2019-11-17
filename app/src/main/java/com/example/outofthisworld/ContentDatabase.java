package com.example.outofthisworld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class ContentDatabase {

    public static ContentDetail getTopicById(int topicID) { return topics.get(topicID); }

    public static ArrayList<ContentDetail> getAllMenuitems() {
        return new ArrayList<ContentDetail>((List) Arrays.asList(topics.values().toArray()));
    }

    private static final HashMap<Integer, ContentDetail> topics = new HashMap<>();

    // store data for content_detail.xml page
    static {
        topics.put(1, new ContentDetail(
                1, "The Basics of Astronomy", "Content:\n" +
                "\n" +
                "Astronomy is the scientific study of celestial objects — e.g. Planets, Stars, Galaxies, and the Universe as a whole.\n" +
                "It encompasses the study of everything outside the Earth's atmosphere.\n" +
                "The name derives from the Greek words astron (\"star\") and nomos (\"law\").\n" +
                "\n" +
                "Tools of Astronomy:\n" +
                "\n" +
                "1.\tTelescope: Astronomers use telescopes to observe celestial objects\n" +
                "2.\tSpacecraft: spacecraft that fly past, orbit them or land on planets or other objects\n" +
                "3.\tComputer: computers analyse their data and produce mathematical models that can be compared with observations. The green II supercomputer at Swinburne is an example\n" +
                "4.\tLaboratories: while astronomical research is mostly observational rather than lab experiments, astronomers use labs to develop instruments for use on telescopes and spacecraft to measure fundamental properties needed to interpret data. \n" +
                "\n" +
                "\n" +
                "Ptolemaic System\n" +
                "The Geocentric model is a model of the universe with the Earth at its centre. Greek philosophers believed that celestial objects should move in circular paths because the circle was the most perfect figure according to Plato. But it was clear that the planetary motion could not be modelled with a single circular motion about the Earth. To explain these effects the Greek astronomers developed increasingly complex systems of spheres carried on other spheres, or circles carried on larger circles. This system of explaining the planetary motions reached its culmination with the work of Claudius Ptolemy (ca 100-170 AD). His model for the planetary motions which is based on the geocentric model, and an even more elaborate system of circles on circles (or \"epicycles\"). This epicycles model was necessary to explain features such as the retrograde motion of the planet Mars. There are times when Mars appears to move backward relative to the stars compared with the normal east to west motion most of the time.\n" +
                "Copernican System\n" +
                "It wasn't until 1543 that there was a challenge to the Ptolemaic system. This was when Polish astronomer Nicolaus Copernicus published his book De Revolutionibus Orbium Coelestium (On the Revolutions of the Celestial Spheres). The Copernican system provided a simpler explanation of the retrograde motion of Mars. It occurred as a result of Earth catching up with, and passing Mars due to its faster orbital motion. But Copernicus still used the platonic idea of circular motions and so he still needed systems of multiple circles to explain the actual motions of the planets (which move on elliptical, rather than circular orbits). \n" +
                "\n" +
                "Kepler’s laws\n" +
                "The final solution to the problem provided by German astronomer Johannes Kepler (1571-1601) to determine that the orbits of planets were ellipses not circles\n" +
                "Kepler was able to outline three laws of planetary motion.\n" +
                "Kepler's 1st law:  The planets move in elliptical paths with the Sun at one focus.\n" +
                "Kepler's 2nd law: The line between the planet and the Sun sweeps out equal areas in equal times.\n" +
                "Kepler's 3rd law: The square of the orbital period of the planet is proportional to the cube of the semi-major axis of the orbit.\n" +
                "\n",
                R.drawable.topic1
        ));

        topics.put(2, new ContentDetail(
                2, "Newton and Gravitation", "•\tThe final stage of understanding the structure of the Solar system came from Isaac Newton (1642 - 1726) and his account of gravitation - his Universal Law of Gravitation. It was described in his book the Philosophiae Naturalis Principia Mathematica, usually just known as the Principia, published in 1687.\n" +
                "•\tNewton showed that the elliptical orbits that Kepler had found were exactly what was expected if the planets were attracted to the Sun by a universal force of gravitation that acts between any two objects in the universe and depends on their mass.\n" +
                "•\tIn particular, he realised that the force that explains the orbits of, for example, the Moon around the Earth, is the same force that causes objects to fall to the ground and causes the phenomenon of weight.\n" +
                "•\tHe drew the picture above showing that if an object, such as a cannonball, were fired with sufficient speed from a high mountaintop, it would not fall to Earth, because the curvature of the Earth would fall away at the same rate as the cannonball would fall, and thus it would complete an orbit of the Earth.\n",
                R.drawable.topic2
        ));

        topics.put(3, new ContentDetail(
                3, "Stellar Parallax", "Once the Solar System was understood, astronomers could turn their attention to more distant objects. Indeed, one of the objections that had been proposed to the Copernican theory was that we should expect the motion of the Earth to change the apparent positions of stars. A nearby star should change its position relative to the background of more distant stars as the orbit of the Earth moved it around the Sun. This effect is known as stellar parallax. If it could be detected, then it would provide a way of measuring the distances of stars.\n" +
                "\n" +
                "The failure to observe such parallax was used as an argument against the Copernican theory.\n" +
                "However, the reason it could not be measured was mostly because the stars are so distant, that the parallax movement is extremely small. In fact, it is less than one second of arc for even the nearest stars, and could not be measured until techniques for the accurate measurement of star positions reached the requisite precision.\n" +
                "The first successful measurement of stellar parallax was made in 1838 by Friedrich Bessel. He measured the parallax of the star 61 Cygni and obtained a distance of 9.8 light years.\n" +
                "Other measurements of stellar parallax rapidly followed, and Alpha Centauri was found to be the closest star system to our own Sun at a distance of about 4.3 light years.\n" +
                "These measurements helped confirm not only that the Earth really does orbit around the Sun, but also what had long been expected - that the stars were other suns. The distances measured were consistent with stars being objects as bright as the Sun but seen from much greater distances.\n",
                R.drawable.topic3
        ));

        topics.put(4, new ContentDetail(
                4, "Milky Way Galaxy", "•\tThis meant that not only was the Earth no longer at the centre of the universe, but even the Sun itself was just one of billions of stars making up our Milky Way galaxy.\n" +
                "•\tWith the naked eye we can only see at best a few thousand stars, but even with Galileo's telescope revealed that the Milky way was made up of many stars. As telescopes became more powerful, we realised that the number of stars in our Milky Way galaxy was in the billions. In fact it is now thought there are several hundred billions of stars in the Milky Way. The Milky Way has a diameter of about 100000 light years.\n" +
                "•\tIn the early 20th century, astronomers began to realise that our Milky Way galaxy was itself just one among many. They found that objects that had been called spiral nebulae, were not actually nebulae (clouds of gas), but were other galaxies comparable to our own.\n" +
                "•\tOne of the nearest and best-known galaxies is M31 in Andromeda shown below, and observations by Edwin Hubble showed that galaxies like this really were systems of billions of stars just like our own Milky way galaxy.\n",
                R.drawable.topic4
        ));

        topics.put(5, new ContentDetail(
                5, "Scale of The Universe", "Starting with the Solar system, the distance from the Earth to the Sun is about 150 million kilometres and is called an astronomical unit (AU).\n" +
                "\n" +
                "If we go out to the orbit of the outermost planet Neptune, we are now getting out 4,500 million km. It takes light (travelling at a speed of 300,000 km/s) about 8 minutes 20 seconds to get from the Sun to the Earth, and 4 hours to get from the Earth out to the orbit of Neptune.\n" +
                "You can see that even within our own solar system distances are enormous numbers of km. Hence a unit we use to measure distances in astronomy is the light year.\n" +
                "•\tA light year is a measure of distance — not time.\n" +
                "•\tIt is the distance light travels in one year.\n" +
                "•\tThe speed of light is 300,000 km per second (km/s).\n" +
                "•\tSo one light year is:  9,460,700,000,000 km  (i.e. about 9.5 trillion km) and is about 63,241 astronomical units.\n" +
                "•\tEven so, we see distant (very bright) objects that are billions of light years away.\n" +
                "\n" +
                "We can now look at distances within our Milky Way galaxy. The nearest star is about 4.3 light years away. The Sun is about 25,000 light years from the centre of the galaxy. The Milky Way galaxy is a disk about 100,000 light years across, and it contains about 200 billion stars.\n",
                R.drawable.topic5
        ));

        topics.put(6, new ContentDetail(
                6, "Introduction to Astrobiology", "What is Astrobiology?\n" +
                "-\tThe science of life in the universe\n" +
                "-\tAstrobiologists answer key questions: \n" +
                "o\tHow does life begin and evolve?\n" +
                "o\tDoes life exist elsewhere in universe\n" +
                "o\tWhat is future of life on earth and beyond\n" +
                "\n" +
                "Life in the universe\n" +
                "\n" +
                "•\tWhy life might be common: the vastness of the universe. The universe consists of many billions of galaxies, which each galaxy containing many billions of stars. \n" +
                "•\tWhy life might be rare or unique: the chemical machinery of living cells is extremely complex. Chance of such a cell forming by chance would be negligible. \n" +
                "\n" +
                "The number of planets with life\n" +
                "\n" +
                "•\tA simple equation for the number of planets we might expect to find with life on them:\n" +
                "\n" +
                "Number of planets with life = Number of habitable planets x Probability of life's origin\n" +
                "•\tThe number of habitable planets we don’t know for sure, but we think it’s probably a big number \n" +
                "\n" +
                "To better understand the probability of life, we need to have a better understanding of these 2 numbers.\n" +
                "•\tFor the number of habitable planets, we need to understand planets:\n" +
                "o\twe need to understand how they formed,\n" +
                "o\twhether they are likely to be habitable,\n" +
                "o\tand how they evolve.\n" +
                "•\tThis involves the sciences of:\n" +
                "o\tastronomy,\n" +
                "o\tplanetary science,\n" +
                "o\tand geology.\n" +
                "•\tBut in order to get the probability of life's origin we need to understand life:\n" +
                "o\tWe need to understand how life works,\n" +
                "o\thow it originates,\n" +
                "o\tand how it evolves.\n" +
                "Life on Earth \n" +
                "\n" +
                "•\tWe think that life has existed for about 3.5 billion years, at least in the form of microbial life- bacteria and similar things\n" +
                "\n" +
                "•\tBut complex life-macro organisms like animals and plants- has only been around for 500 million years, which is a relatively small fraction of the Earth’s history.\n" +
                "\n" +
                "•\tModern humans have only been around for 50,000 years\n" +
                "\n" +
                "•\tThe technology to travel in space or to send signals in space has only been around for little over 50 years.\n" +
                "\n" +
                "Life on other planets?\n" +
                "•\tThe sort of bacteria we might expect to find are organisms called cyanobacteria, which literally means blue-green bacteria. We think those are the organisms that produced the oxygen in the Earth's atmosphere. They were the first living organisms that photosynthesised and produced oxygen. \n" +
                "•\tIf we can find just one example of life on another planet, say Mars, and show that it formed independently of life on Earth, even if it's only microbes, this proves that life forms easily, given the right conditions\n" +
                "\n",
                R.drawable.topic6
        ));
    }

    public static HashMap<Integer, ContentDetail> youtubeVidMap = new HashMap(){{
        put(1, new ContentDetail(0, "6TGCPXhMLtU"));
        put(2, new ContentDetail(1, "TRAbZxQHlVw"));
        put(3, new ContentDetail(2, "iwlMmJs1f5o"));
        put(4, new ContentDetail(3, "tj_QPnO8vpQ"));
        put(5, new ContentDetail(4, "Op3AYaJc0Xw"));
        put(6, new ContentDetail(5, "bo4mEtc434w"));
    }};

    public static ContentDetail getVideoById(int topicid) {
        return youtubeVidMap.get(topicid);
    }
}