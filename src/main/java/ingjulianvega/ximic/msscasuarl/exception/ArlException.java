package ingjulianvega.ximic.msscasuarl.exception;

import lombok.Getter;

@Getter
public class ArlException extends RuntimeException {

    private final String code;

    public ArlException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

