package br.com.ecb.bloodbankapi.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Range {
    private Integer start;
    private Integer end;

    public String toString() {
        return start + " - " + end;
    }
}
