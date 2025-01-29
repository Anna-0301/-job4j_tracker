package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    public String getEvenElements() {
        StringBuilder string1 = new StringBuilder(evenElements.size());
        for (int i = evenElements.size(); i > 0; i--) {
            if (i % 2 != 0) {
                evenElements.poll();
            } else {
                string1.append(evenElements.poll());
            }
        }
        return String.valueOf(string1);
    }

    public String getDescendingElements() {
        StringBuilder string2 = new StringBuilder();
        for (int i = descendingElements.size(); i > 0; i--) {
            string2.append(descendingElements.pollLast());
        }
        return String.valueOf(string2);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
