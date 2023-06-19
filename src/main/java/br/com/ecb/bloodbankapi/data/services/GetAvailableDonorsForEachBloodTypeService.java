package br.com.ecb.bloodbankapi.data.services;

import br.com.ecb.bloodbankapi.domain.features.GetAvailableDonorsForEachBloodType;
import br.com.ecb.bloodbankapi.domain.models.person.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class GetAvailableDonorsForEachBloodTypeService implements GetAvailableDonorsForEachBloodType {
    public List<Object> handle(List<Person> people) {
        AtomicReference<Integer> typeAPlusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeAMinusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeBPlusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeBMinusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeABPlusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeABMinusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeOPlusQuantity = new AtomicReference<>(0);
        AtomicReference<Integer> typeOMinusQuantity = new AtomicReference<>(0);

        ArrayList<Object> results = new ArrayList<>();

        people.forEach(person -> {

            if ((person.getAge() < 16 || person.getAge() > 69) && person.getInfo().getWeight() <= 50) {
                return;
            }

            switch (person.getInfo().getBloodType()) {
                case "A+" -> {
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                    typeAPlusQuantity.getAndSet(typeAPlusQuantity.get() + 1);
                }
                case "A-" -> {
                    typeAPlusQuantity.getAndSet(typeAPlusQuantity.get() + 1);
                    typeAMinusQuantity.getAndSet(typeAMinusQuantity.get() + 1);
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                    typeABMinusQuantity.getAndSet(typeABMinusQuantity.get() + 1);
                }
                case "B+" -> {
                    typeBPlusQuantity.getAndSet(typeBPlusQuantity.get() + 1);
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                }
                case "B-" -> {
                    typeBPlusQuantity.getAndSet(typeBPlusQuantity.get() + 1);
                    typeBMinusQuantity.getAndSet(typeBMinusQuantity.get() + 1);
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                    typeABMinusQuantity.getAndSet(typeABMinusQuantity.get() + 1);
                }
                case "AB+" -> typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                case "AB-" -> {
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                    typeABMinusQuantity.getAndSet(typeABMinusQuantity.get() + 1);
                }
                case "O+" -> {
                    typeAPlusQuantity.getAndSet(typeAPlusQuantity.get() + 1);
                    typeBPlusQuantity.getAndSet(typeBPlusQuantity.get() + 1);
                    typeOPlusQuantity.getAndSet(typeOPlusQuantity.get() + 1);
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                }
                case "O-" -> {
                    typeAPlusQuantity.getAndSet(typeAPlusQuantity.get() + 1);
                    typeBPlusQuantity.getAndSet(typeBPlusQuantity.get() + 1);
                    typeOPlusQuantity.getAndSet(typeOPlusQuantity.get() + 1);
                    typeABPlusQuantity.getAndSet(typeABPlusQuantity.get() + 1);
                    typeAMinusQuantity.getAndSet(typeAMinusQuantity.get() + 1);
                    typeBMinusQuantity.getAndSet(typeBMinusQuantity.get() + 1);
                    typeOMinusQuantity.getAndSet(typeOMinusQuantity.get() + 1);
                    typeABMinusQuantity.getAndSet(typeABMinusQuantity.get() + 1);
                }
            }
        });

        results.add(
                new HashMap<>() {{
                    put("bloodType", "A+");
                    put("quantity", typeAPlusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "A-");
                    put("quantity", typeAMinusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "B+");
                    put("quantity", typeBPlusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "B-");
                    put("quantity", typeBMinusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "AB+");
                    put("quantity", typeABPlusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "AB-");
                    put("quantity", typeABMinusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "O+");
                    put("quantity", typeOPlusQuantity);
                }}
        );

        results.add(
                new HashMap<>() {{
                    put("bloodType", "O-");
                    put("quantity", typeOMinusQuantity);
                }}
        );

        return results;
    }
}
