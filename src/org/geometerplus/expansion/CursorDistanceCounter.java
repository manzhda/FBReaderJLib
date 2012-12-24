package org.geometerplus.expansion;

import org.geometerplus.zlibrary.text.view.ZLTextSelection;
import org.geometerplus.zlibrary.text.view.ZLTextSelectionCursor;

public interface CursorDistanceCounter {
    public int distance(ZLTextSelectionCursor cursor, ZLTextSelection.Point cursorPoint, int x, int y);
}
