package org.geometerplus.expansion;

import org.geometerplus.fbreader.library.Book;
import org.geometerplus.zlibrary.text.view.ZLTextHighlighting;

import java.util.List;

public interface HighlightStorage {
    public List<ZLTextHighlighting> loadHighlights(Book book);
    public void saveHighlight(Book book, ZLTextHighlighting highlight);
    public void deleteHighlight(ZLTextHighlighting highlight);
}
