package sample;

import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Data
public class Restaurant {
    @Setter(onMethod_ = {@Inject})
    private Chef chef;
}
