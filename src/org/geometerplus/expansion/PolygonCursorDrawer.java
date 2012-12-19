package org.geometerplus.expansion;

import org.geometerplus.zlibrary.core.view.ZLPaintContext;
import org.geometerplus.zlibrary.text.view.ZLTextHyperlink;
import org.geometerplus.zlibrary.text.view.ZLTextSelection;
import org.geometerplus.zlibrary.text.view.ZLTextSelectionCursor;
import org.geometerplus.zlibrary.text.view.ZLTextView;

public class PolygonCursorDrawer implements CursorDrawer {
    private final ZLTextView mZLTextView;

    public PolygonCursorDrawer(ZLTextView zlTextView) {
        mZLTextView = zlTextView;
    }

    @Override
    public void drawSelectionCursor(ZLPaintContext context, ZLTextSelection.Point pt, ZLTextSelectionCursor cursor) {
        final int w = ZLTextSelectionCursor.getWidth() / 2;
        final int h = ZLTextSelectionCursor.getHeight();
        final int a = ZLTextSelectionCursor.getAccent();
        final int[] xs = { pt.X, pt.X + w, pt.X + w, pt.X - w, pt.X - w };
        final int[] ys = { pt.Y - a, pt.Y, pt.Y + h, pt.Y + h, pt.Y };
        context.setFillColor(context.getBackgroundColor(), 192);
        context.fillPolygon(xs, ys);
        context.setLineColor(mZLTextView.getTextColor(ZLTextHyperlink.NO_LINK));
        context.drawPolygonalLine(xs, ys);
    }
}
