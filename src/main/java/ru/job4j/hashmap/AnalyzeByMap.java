package ru.job4j.hashmap;

import java.util.*;
import java.util.Collections;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double result = 0;
        double sumScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
                result = sumScore / pupils.size() / pupil.subjects().size();
            }
        }
        return result;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        double sumScore = 0;
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labels.add(new Label(pupil.name(), sumScore / pupil.subjects().size()));
            sumScore = 0;
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> tempMapAverage = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMapAverage.put(subject.name(), subject.score()
                        + (tempMapAverage.get(subject.name()) == null ? 0 : tempMapAverage.get(subject.name())));
            }
        }
        for (String key : tempMapAverage.keySet()) {
            labels.add(new Label(key, tempMapAverage.get(key) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<String, Integer> tempMapAverage = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMapAverage.put(pupil.name(), subject.score()
                        + (tempMapAverage.get(pupil.name()) == null ? 0 : tempMapAverage.get(pupil.name())));
            }
        }
        for (String key : tempMapAverage.keySet()) {
            labels.add(new Label(key, tempMapAverage.get(key)));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> tempMapAverage = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                tempMapAverage.put(subject.name(), subject.score()
                        + (tempMapAverage.get(subject.name()) == null ? 0 : tempMapAverage.get(subject.name())));
            }
            for (String key : tempMapAverage.keySet()) {
                labels.add(new Label(key, tempMapAverage.get(key)));
            }
            Collections.sort(labels);
        }
        return labels.get(labels.size() - 1);
    }
}
