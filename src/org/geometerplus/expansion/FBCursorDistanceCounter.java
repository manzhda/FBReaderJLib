package org.geometerplus.expansion;

import org.geometerplus.zlibrary.text.view.ZLTextSelection;
import org.geometerplus.zlibrary.text.view.ZLTextSelectionCursor;

public class FBCursorDistanceCounter implements CursorDistanceCounter {
    @Override
    public int distance(ZLTextSelectionCursor cursor, ZLTextSelection.Point cursorPoint, int x, int y) {
        if (cursorPoint == null) {
            return Integer.MAX_VALUE;
        }

        final int dX, dY;

        final int w = ZLTextSelectionCursor.getWidth() / 2;
        if (x < cursorPoint.X - w) {
            dX = cursorPoint.X - w - x;
        } else if (x > cursorPoint.X + w) {
            dX = x - cursorPoint.X - w;
        } else {
            dX = 0;
        }

        final int h = ZLTextSelectionCursor.getHeight();
        if (y < cursorPoint.Y) {
            dY = cursorPoint.Y - y;
        } else if (y > cursorPoint.Y + h) {
            dY = y - cursorPoint.Y - h;
        } else {
            dY = 0;
        }

        return Math.max(dX, dY);
    }
}
