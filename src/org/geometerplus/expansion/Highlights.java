package org.geometerplus.expansion;

import org.geometerplus.zlibrary.text.view.ZLTextHighlighting;
import org.geometerplus.zlibrary.text.view.ZLTextPosition;

import java.util.Collection;

public interface Highlights {
    public void addHighlighting(ZLTextPosition start, ZLTextPosition end);
    public boolean clear();
    public Collection<ZLTextHighlighting> getHighlightings();
}
