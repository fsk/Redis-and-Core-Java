package org.fsk.redis;

import java.math.BigDecimal;

public record Bicycle(String brand, String model, BigDecimal price, String description, String condition) {
}
