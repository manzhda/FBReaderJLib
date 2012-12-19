package org.geometerplus.expansion;

import org.geometerplus.zlibrary.text.view.ZLTextHighlighting;
import org.geometerplus.zlibrary.text.view.ZLTextPosition;

import java.util.ArrayList;
import java.util.Collection;

public class SingleHighlight implements Highlights {
    private ZLTextHighlighting mHighlighting = new ZLTextHighlighting();
    private Collection<ZLTextHighlighting> mHighlightings = new ArrayList<ZLTextHighlighting>();

    public SingleHighlight() {
        mHighlightings.add(mHighlighting);
    }

    @Override
    public void addHighlighting(ZLTextPosition start, ZLTextPosition end) {
        mHighlighting.setup(start, end);
    }

    @Override
    public boolean clear() {
        return mHighlighting.clear();
    }

    @Override
    public Collection<ZLTextHighlighting> getHighlightings() {
        return mHighlightings;
    }
}
