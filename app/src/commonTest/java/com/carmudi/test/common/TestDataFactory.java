package com.carmudi.test.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.carmudi.test.data.model.NamedResource;
import com.carmudi.test.data.model.ResultsItem;
import com.carmudi.test.data.model.Sprites;
import com.carmudi.test.data.model.Statistic;

/**
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */
public class TestDataFactory {

    private static final Random sRandom = new Random();

    public static String randomUuid() {
        return UUID.randomUUID().toString();
    }

    public static ResultsItem makeItem() {
        ResultsItem resultsItem = new ResultsItem();
        return resultsItem;
    }

    public static List<ResultsItem> makeCarNameList(int count) {
        List<ResultsItem> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            carList.add(makeItem());
        }
        return carList;
    }

    public static List<String> makePokemonNameList(List<NamedResource> pokemonList) {
        List<String> names = new ArrayList<>();
        for (NamedResource pokemon : pokemonList) {
            names.add(pokemon.name);
        }
        return names;
    }

    public static Statistic makeStatistic() {
        Statistic statistic = new Statistic();
        statistic.baseStat = sRandom.nextInt();
        statistic.stat = makeNamedResource(randomUuid());
        return statistic;
    }

    public static List<Statistic> makeStatisticList(int count) {
        List<Statistic> statisticList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            statisticList.add(makeStatistic());
        }
        return statisticList;
    }

    public static Sprites makeSprites() {
        Sprites sprites = new Sprites();
        sprites.frontDefault = randomUuid();
        return sprites;
    }

    public static NamedResource makeNamedResource(String unique) {
        NamedResource namedResource = new NamedResource();
        namedResource.name = randomUuid() + unique;
        namedResource.url = randomUuid();
        return namedResource;
    }

    public static List<NamedResource> makeNamedResourceList(int count) {
        List<NamedResource> namedResourceList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            namedResourceList.add(makeNamedResource(String.valueOf(i)));
        }
        return namedResourceList;
    }
}