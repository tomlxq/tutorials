/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/2/26
 */
package com.tom.hashtable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Word {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }

        Word word = (Word) o;
        return word.getName().equals(this.name) ? true : false;

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
