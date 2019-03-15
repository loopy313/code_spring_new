package sample;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
@Data
@RequiredArgsConstructor
public class Restaurant {
    @Setter(onMethod_ = {@Inject})
    private Chef chef;
}
