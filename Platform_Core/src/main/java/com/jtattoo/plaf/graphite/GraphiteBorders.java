/*
* Copyright (c) 2002 and later by MH Software-Entwicklung. All Rights Reserved.
*  
* JTattoo is multiple licensed. If your are an open source developer you can use
* it under the terms and conditions of the GNU General Public License version 2.0
* or later as published by the Free Software Foundation.
*  
* see: gpl-2.0.txt
* 
* If you pay for a license you will become a registered user who could use the
* software under the terms and conditions of the GNU Lesser General Public License
* version 2.0 or later with classpath exception as published by the Free Software
* Foundation.
* 
* see: lgpl-2.0.txt
* see: classpath-exception.txt
* 
* Registered users could also use JTattoo under the terms and conditions of the 
* Apache License, Version 2.0 as published by the Apache Software Foundation.
*  
* see: APACHE-LICENSE-2.0.txt
*/
 
package com.jtattoo.plaf.graphite;

import com.jtattoo.plaf.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;

/**
 * The Class GraphiteBorders.
 *
 * @author Michael Hagen
 */
public class GraphiteBorders extends BaseBorders {

//------------------------------------------------------------------------------------
// Lazy access methods
/**
 * Gets the button border.
 *
 * @return the button border
 */
//------------------------------------------------------------------------------------
    public static Border getButtonBorder() {
        if (buttonBorder == null) {
            buttonBorder = new ButtonBorder();
        }
        return buttonBorder;
    }

    /** Gets the toggle button border.
	 *
	 * @return the toggle button border
	 */
    public static Border getToggleButtonBorder() {
        return getButtonBorder();
    }

    /** Gets the rollover tool button border.
	 *
	 * @return the rollover tool button border
	 */
    public static Border getRolloverToolButtonBorder() {
        if (rolloverToolButtonBorder == null) {
            rolloverToolButtonBorder = new RolloverToolButtonBorder();
        }
        return rolloverToolButtonBorder;
    }

    /** Gets the menu item border.
	 *
	 * @return the menu item border
	 */
    public static Border getMenuItemBorder() {
        if (menuItemBorder == null) {
            menuItemBorder = new MenuItemBorder();
        }
        return menuItemBorder;
    }

    /** Gets the popup menu border.
	 *
	 * @return the popup menu border
	 */
    public static Border getPopupMenuBorder() {
        if (popupMenuBorder == null) {
            if (AbstractLookAndFeel.getTheme().isMenuOpaque()) {
                popupMenuBorder = new PopupMenuBorder();
            } else {
                popupMenuBorder = new BasePopupMenuShadowBorder();
            }
        }
        return popupMenuBorder;
    }

    /** Gets the internal frame border.
	 *
	 * @return the internal frame border
	 */
    public static Border getInternalFrameBorder() {
        if (internalFrameBorder == null) {
            internalFrameBorder = new InternalFrameBorder();
        }
        return internalFrameBorder;
    }

//------------------------------------------------------------------------------------
// Inner classes
/**
 * The Class ButtonBorder.
 */
//------------------------------------------------------------------------------------
    public static class ButtonBorder implements Border, UIResource {

        /** The Constant defaultColorHi. */
        private static final Color defaultColorHi = new Color(220, 230, 245);
        
        /** The Constant defaultColorLo. */
        private static final Color defaultColorLo = new Color(212, 224, 243);
        
        /** The Constant insets. */
        private static final Insets insets = new Insets(3, 8, 3, 8);

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Graphics2D g2D = (Graphics2D) g;
            AbstractButton button = (AbstractButton) c;
            Color frameColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 30);
            if (AbstractLookAndFeel.getTheme().doShowFocusFrame() && button.hasFocus()) {
                frameColor = AbstractLookAndFeel.getTheme().getFocusFrameColor();
            }
            
            if (AbstractLookAndFeel.getTheme().doDrawSquareButtons()) {
                Composite savedComposite = g2D.getComposite();
                AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
                g2D.setComposite(alpha);
                g2D.setColor(Color.white);
                g2D.drawRect(x, y, w - 1, h - 1);
                g2D.setComposite(savedComposite);
                
                if (button.getRootPane() != null && button.equals(button.getRootPane().getDefaultButton()) && !button.hasFocus()) {
                    g2D.setColor(ColorHelper.darker(frameColor, 20));
                    g2D.drawRect(x, y, w - 1, h - 2);
                    if (!button.getModel().isRollover()) {
                        g2D.setColor(defaultColorHi);
                        g2D.drawRect(x + 1, y + 1, w - 3, h - 4);
                        g2D.setColor(defaultColorLo);
                        g2D.drawRect(x + 2, y + 2, w - 5, h - 6);
                    }
                } else {
                    g2D.setColor(frameColor);
                    g2D.drawRect(x, y, w - 2, h - 2);
                }
            } else {
                Object savedRederingHint = g2D.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Composite savedComposite = g2D.getComposite();
                AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
                g2D.setComposite(alpha);
                g2D.setColor(Color.white);
                g2D.drawRoundRect(x, y, w - 1, h - 1, 6, 6);
                g2D.setComposite(savedComposite);

                if (button.getRootPane() != null && button.equals(button.getRootPane().getDefaultButton()) && !button.hasFocus()) {
                    g2D.setColor(ColorHelper.darker(frameColor, 20));
                    g2D.drawRoundRect(x, y, w - 1, h - 2, 6, 6);
                    if (!button.getModel().isRollover()) {
                        g2D.setColor(defaultColorHi);
                        g2D.drawRoundRect(x + 1, y + 1, w - 3, h - 4, 6, 6);
                        g2D.setColor(defaultColorLo);
                        g2D.drawRoundRect(x + 2, y + 2, w - 5, h - 6, 6, 6);
                    }
                } else {
                    g2D.setColor(frameColor);
                    g2D.drawRoundRect(x, y, w - 1, h - 2, 6, 6);
                }

                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, savedRederingHint);
            }
        }

        public Insets getBorderInsets(Component c) {
            return insets;
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    } // class ButtonBorder

    /** The Class RolloverToolButtonBorder.
	 */
    public static class RolloverToolButtonBorder implements Border, UIResource {

        /** The Constant insets. */
        private static final Insets insets = new Insets(1, 1, 1, 1);

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            AbstractButton button = (AbstractButton) c;
            ButtonModel model = button.getModel();
            Color loColor = ColorHelper.brighter(AbstractLookAndFeel.getFrameColor(), 50);
            if (model.isEnabled()) {
                if ((model.isPressed() && model.isArmed()) || model.isSelected()) {
                    Graphics2D g2D = (Graphics2D) g;
                    Composite composite = g2D.getComposite();
                    g.setColor(loColor);
                    g.drawRect(x, y, w - 1, h - 1);
                    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.15f);
                    g2D.setComposite(alpha);
                    g.setColor(Color.black);
                    g.fillRect(x + 1, y + 1, w - 2, h - 2);
                    g2D.setComposite(composite);
                } else if (model.isRollover()) {
                    Graphics2D g2D = (Graphics2D) g;
                    Composite composite = g2D.getComposite();
                    g.setColor(loColor);
                    g.drawRect(x, y, w - 1, h - 1);
                    AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
                    g2D.setComposite(alpha);
                    g.setColor(Color.white);
                    g.fillRect(x + 1, y + 1, w - 2, h - 2);
                    g2D.setComposite(composite);
                }
            }
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public boolean isBorderOpaque() {
            return true;
        }
    } // class RolloverToolButtonBorder

    /** The Class MenuItemBorder.
	 */
    public static class MenuItemBorder extends AbstractBorder implements UIResource {

        /** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/** The Constant insets. */
		private static final Insets insets = new Insets(2, 2, 2, 2);

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            JMenuItem b = (JMenuItem) c;
            ButtonModel model = b.getModel();
            Color borderColor = ColorHelper.darker(AbstractLookAndFeel.getMenuSelectionBackgroundColor(), 20);
            g.setColor(borderColor);
            if (c.getParent() instanceof JMenuBar) {
                if (model.isArmed() || model.isSelected()) {
                    g.drawLine(x, y, x + w - 1, y);
                    g.drawLine(x, y + 1, x, y + h - 1);
                    g.drawLine(x + w - 1, y + 1, x + w - 1, y + h - 1);
                }
            } else {
                if (model.isArmed() || (c instanceof JMenu && model.isSelected())) {
                    g.drawLine(x, y, x + w - 1, y);
                    g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
                }
            }
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }
    } // class MenuItemBorder

    /** The Class PopupMenuBorder.
	 */
    public static class PopupMenuBorder extends BasePopupMenuBorder {
        
        /** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            Color borderColor = ColorHelper.darker(AbstractLookAndFeel.getMenuSelectionBackgroundColor(), 20);
            if (JTattooUtilities.isLeftToRight(c)) {
                int dx = getBorderInsets(c).left;
                Color logoColorHi = AbstractLookAndFeel.getTheme().getMenuSelectionBackgroundColorDark();
                Color logoColorLo = AbstractLookAndFeel.getTheme().getMenuSelectionBackgroundColor();
                Color colors[] = ColorHelper.createColorArr(logoColorHi, logoColorLo, 32);
                JTattooUtilities.fillHorGradient(g, colors, x, y, dx - 1, h - 1);
                paintLogo(c, g, x, y, w, h);
                // - highlight 
                g.setColor(ColorHelper.brighter(AbstractLookAndFeel.getMenuBackgroundColor(), 40));
                g.drawLine(x + dx, y + 1, x + w - 2, y + 1);
                // - outer frame
                g.setColor(borderColor);
                if (isMenuBarPopup(c)) {
                    // top
                    g.drawLine(x + dx - 1, y, x + w, y);
                    // left
                    g.drawLine(x, y, x, y + h - 1);
                    // bottom
                    g.drawLine(x, y + h - 1, x + w, y + h - 1);
                    // right
                    g.drawLine(x + w - 1, y + 1, x + w - 1, y + h - 1);
                } else {
                    g.drawRect(x, y, w - 1, h - 1);
                }
                // - logo separator
                g.drawLine(x + dx - 1, y + 1, x + dx - 1, y + h - 1);
            } else {
                int dx = getBorderInsets(c).right;
                Color logoColorHi = AbstractLookAndFeel.getTheme().getMenuSelectionBackgroundColorDark();
                Color logoColorLo = AbstractLookAndFeel.getTheme().getMenuSelectionBackgroundColor();
                Color colors[] = ColorHelper.createColorArr(logoColorHi, logoColorLo, 32);
                JTattooUtilities.fillHorGradient(g, colors, x + w - dx, y, dx, h - 1);
                paintLogo(c, g, x, y, w, h);
                // - highlight 
                g.setColor(ColorHelper.brighter(AbstractLookAndFeel.getMenuBackgroundColor(), 40));
                g.drawLine(x + 1, y + 1, x + w - dx - 1, y + 1);
                g.drawLine(x + 1, y + 1, x + 1, y + h - 2);
                // - outer frame
                g.setColor(borderColor);
                if (isMenuBarPopup(c)) {
                    // top
                    g.drawLine(x, y, x + w - dx, y);
                    // left
                    g.drawLine(x, y, x, y + h - 1);
                    // bottom
                    g.drawLine(x, y + h - 1, x + w, y + h - 1);
                    // right
                    g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
                } else {
                    g.drawRect(x, y, w - 1, h - 1);
                }
                // - logo separator
                g.drawLine(x + w - dx, y + 1, x + w - dx, y + h - 1);
            }
        }
       
    }

    /** The Class InternalFrameBorder.
	 */
    public static class InternalFrameBorder extends BaseInternalFrameBorder {

        /** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;

		public InternalFrameBorder() {
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }

        public Insets getBorderInsets(Component c, Insets borderInsets) {
            borderInsets.left = insets.left;
            borderInsets.top = insets.top;
            borderInsets.right = insets.right;
            borderInsets.bottom = insets.bottom;
            return borderInsets;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
            int th = getTitleHeight(c);
            Color titleColor = AbstractLookAndFeel.getWindowTitleColorLight();
            Color borderColor = AbstractLookAndFeel.getWindowTitleColorDark();
            Color frameColor = AbstractLookAndFeel.getWindowBorderColor();
            if (!isActive(c)) {
                titleColor = AbstractLookAndFeel.getWindowInactiveTitleColorLight();
                borderColor = AbstractLookAndFeel.getWindowInactiveTitleColorDark();
                frameColor = AbstractLookAndFeel.getWindowInactiveBorderColor();
            }

            g.setColor(titleColor);
            g.fillRect(x, y + 1, w, insets.top - 1);
            g.setColor(titleColor);
            g.fillRect(x + 1, y + h - dw, w - 2, dw - 1);

            if (isActive(c)) {
                JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), 1, insets.top, dw, th + 1);
                JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), w - dw - 1, insets.top, dw, th + 1);
                g.setColor(borderColor);
                JTattooUtilities.fillInverseHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), 1, insets.top + th + 1, dw - 1, h - th - dw);
                JTattooUtilities.fillInverseHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), w - dw, insets.top + th + 1, dw - 1, h - th - dw);
            } else {
                JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), 1, insets.top, dw, th + 1);
                JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), w - dw - 1, insets.top, dw, th + 1);
                g.setColor(borderColor);
                JTattooUtilities.fillInverseHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), 1, insets.top + th + 1, dw - 1, h - th - dw);
                JTattooUtilities.fillInverseHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), w - dw, insets.top + th + 1, dw - 1, h - th - dw);
            }

            g.setColor(frameColor);
            g.drawRect(x, y, w - 1, h - 1);
            g.drawLine(x + dw - 1, y + insets.top + th, x + dw - 1, y + h - dw);
            g.drawLine(x + w - dw, y + insets.top + th, x + w - dw, y + h - dw);
            g.drawLine(x + dw - 1, y + h - dw, x + w - dw, y + h - dw);
        }
    } // class InternalFrameBorder
    
} // class GraphiteBorders

