package chapter1;

import java.util.Objects;

public class BarName {
        private String name;

        public BarName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (null == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BarName other = (BarName) o;

            return Objects.equals(this.name, other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
}