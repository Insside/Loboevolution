/*
    GNU LESSER GENERAL PUBLIC LICENSE
    Copyright (C) 2006 The Lobo Project. Copyright (C) 2014 Lobo Evolution

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

    Contact info: lobochief@users.sourceforge.net; ivan.difrancesco@yahoo.it
 */
/*
 * Copyright (c) 2003 World Wide Web Consortium,
 * (Massachusetts Institute of Technology, Institut National de
 * Recherche en Informatique et en Automatique, Keio University). All
 * Rights Reserved. This program is distributed under the W3C's Software
 * Intellectual Property License. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.
 * See W3C License http://www.w3.org/Consortium/Legal/ for more details.
 */

package org.lobobrowser.html.w3c;

import org.w3c.dom.Document;

/**
 * Create a frame. See the FRAME element definition in HTML 4.01.
 * <p>
 * See also the <a
 * 
 * Object Model (DOM) Level 2 HTML Specification</a>.
 */
public interface HTMLFrameElement extends HTMLElement {
	/**
	 * Request frame borders. See the frameborder attribute definition in HTML
	 * 4.01.
	 */
	public String getFrameBorder();

	/**
	 * Request frame borders. See the frameborder attribute definition in HTML
	 * 4.01.
	 */
	public void setFrameBorder(String frameBorder);

	/**
	 * URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
	 * designating a long description of this image or frame. See the longdesc
	 * attribute definition in HTML 4.01.
	 */
	public String getLongDesc();

	/**
	 * URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
	 * designating a long description of this image or frame. See the longdesc
	 * attribute definition in HTML 4.01.
	 */
	public void setLongDesc(String longDesc);

	/**
	 * Frame margin height, in pixels. See the marginheight attribute definition
	 * in HTML 4.01.
	 */
	public String getMarginHeight();

	/**
	 * Frame margin height, in pixels. See the marginheight attribute definition
	 * in HTML 4.01.
	 */
	public void setMarginHeight(String marginHeight);

	/**
	 * Frame margin width, in pixels. See the marginwidth attribute definition
	 * in HTML 4.01.
	 */
	public String getMarginWidth();

	/**
	 * Frame margin width, in pixels. See the marginwidth attribute definition
	 * in HTML 4.01.
	 */
	public void setMarginWidth(String marginWidth);

	/**
	 * The frame name (object of the <code>target</code> attribute). See the
	 * name attribute definition in HTML 4.01.
	 */
	public String getName();

	/**
	 * The frame name (object of the <code>target</code> attribute). See the
	 * name attribute definition in HTML 4.01.
	 */
	public void setName(String name);

	/**
	 * When true, forbid user from resizing frame. See the noresize attribute
	 * definition in HTML 4.01.
	 */
	public boolean getNoResize();

	/**
	 * When true, forbid user from resizing frame. See the noresize attribute
	 * definition in HTML 4.01.
	 */
	public void setNoResize(boolean noResize);

	/**
	 * Specify whether or not the frame should have scrollbars. See the
	 * scrolling attribute definition in HTML 4.01.
	 */
	public String getScrolling();

	/**
	 * Specify whether or not the frame should have scrollbars. See the
	 * scrolling attribute definition in HTML 4.01.
	 */
	public void setScrolling(String scrolling);

	/**
	 * A URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
	 * designating the initial frame contents. See the src attribute definition
	 * in HTML 4.01.
	 */
	public String getSrc();

	/**
	 * A URI [<a href='http://www.ietf.org/rfc/rfc2396.txt'>IETF RFC 2396</a>]
	 * designating the initial frame contents. See the src attribute definition
	 * in HTML 4.01.
	 */
	public void setSrc(String src);

	/**
	 * The document this frame contains, if there is any and it is available, or
	 * <code>null</code> otherwise.
	 * 
	 * @since DOM Level 2
	 */
	public Document getContentDocument();

}
