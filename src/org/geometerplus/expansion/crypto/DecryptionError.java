package org.geometerplus.expansion.crypto;

import java.io.IOException;

public class DecryptionError extends IOException {
    public DecryptionError(Throwable cause) {
        initCause(cause);
    }
}
