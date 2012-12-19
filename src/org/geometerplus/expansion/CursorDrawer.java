package org.geometerplus.expansion;

import org.geometerplus.zlibrary.core.view.ZLPaintContext;
import org.geometerplus.zlibrary.text.view.ZLTextSelection;
import org.geometerplus.zlibrary.text.view.ZLTextSelectionCursor;

public interface CursorDrawer {
    public void drawSelectionCursor(ZLPaintContext context, ZLTextSelection.Point pt, ZLTextSelectionCursor cursor);
}
