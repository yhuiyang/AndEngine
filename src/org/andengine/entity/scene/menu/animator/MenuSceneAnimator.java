package org.andengine.entity.scene.menu.animator;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.util.adt.align.HorizontalAlign;
import org.andengine.util.adt.align.VerticalAlign;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 *
 * @author Nicolas Gramlich
 * @since 11:17:32 - 02.04.2010
 */
public abstract class MenuSceneAnimator implements IMenuSceneAnimator {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final HorizontalAlign HORIZONTALALIGN_DEFAULT = HorizontalAlign.CENTER;
	private static final VerticalAlign VERTICALALIGN_DEFAULT = VerticalAlign.CENTER;
	private static final MenuItemOrientation MENUITEMORIENTATION_DEFAULT = MenuItemOrientation.VERTICAL;
	private static final float SPACING_DEFAULT = 1.0f;
	private static final float OFFSET_X_DEFAULT = 0.0f;
	private static final float OFFSET_Y_DEFAULT = 0.0f;

	// ===========================================================
	// Fields
	// ===========================================================

	protected HorizontalAlign mHorizontalAlign;
	protected VerticalAlign mVerticalAlign;

	protected float mOffsetX = MenuSceneAnimator.OFFSET_X_DEFAULT;
	protected float mOffsetY = MenuSceneAnimator.OFFSET_Y_DEFAULT;

	protected float mMenuItemSpacing = MenuSceneAnimator.SPACING_DEFAULT;
	protected float mOverallHeight;
	protected float mOverallWidth;

	protected MenuItemOrientation mMenuItemOrientation = MenuSceneAnimator.MENUITEMORIENTATION_DEFAULT;

	// ===========================================================
	// Constructors
	// ===========================================================

	public MenuSceneAnimator() {
		this(MenuSceneAnimator.HORIZONTALALIGN_DEFAULT, MenuSceneAnimator.VERTICALALIGN_DEFAULT);
	}

	public MenuSceneAnimator(final HorizontalAlign pHorizontalAlign, final VerticalAlign pVerticalAlign) {
		this.mHorizontalAlign = pHorizontalAlign;
		this.mVerticalAlign = pVerticalAlign;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public float getOffsetX() {
		return this.mOffsetX;
	}

	@Override
	public void setOffsetX(final float pOffsetX) {
		this.mOffsetX = pOffsetX;
	}

	@Override
	public float getOffsetY() {
		return this.mOffsetY;
	}

	@Override
	public void setOffsetY(final float pOffsetY) {
		this.mOffsetY = pOffsetY;
	}

	@Override
	public float getMenuItemSpacing() {
		return this.mMenuItemSpacing;
	}

	@Override
	public void setMenuItemSpacing(final float pMenuItemSpacing) {
		this.mMenuItemSpacing = pMenuItemSpacing;
	}

	@Override
	public HorizontalAlign getHorizontalAlign() {
		return this.mHorizontalAlign;
	}

	@Override
	public void setHorizontalAlign(final HorizontalAlign pHorizontalAlign) {
		this.mHorizontalAlign = pHorizontalAlign;
	}

	@Override
	public VerticalAlign getVerticalAlign() {
		return this.mVerticalAlign;
	}

	@Override
	public void setVerticalAlign(final VerticalAlign pVerticalAlign) {
		this.mVerticalAlign = pVerticalAlign;
	}

	@Override
	public MenuItemOrientation getMenuItemOrientation() {
		return this.mMenuItemOrientation;
	}

	@Override
	public void setMenuItemOrientation(final MenuItemOrientation pMenuItemOrientation) {
		this.mMenuItemOrientation = pMenuItemOrientation;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	protected abstract void onMenuItemPositionBuilt(final MenuScene pMenuScene, final int pIndex, final IMenuItem pMenuItem, final float pX, final float pY);
	protected abstract void onMenuItemPositionReset(final MenuScene pMenuScene, final int pIndex, final IMenuItem pMenuItem, final float pX, final float pY);

	@Override
	public void buildMenuSceneAnimations(final MenuScene pMenuScene) {
		this.updateOverallDimension(pMenuScene);

		final int menuItemCount = pMenuScene.getMenuItemCount();

		for (int i = 0; i < menuItemCount; i++) {
			final IMenuItem menuItem = pMenuScene.getMenuItem(i);

			final float x = this.getMenuItemX(pMenuScene, i);
			final float y = this.getMenuItemY(pMenuScene, i);
			this.onMenuItemPositionBuilt(pMenuScene, i, menuItem, x, y);
		}
	}

	@Override
	public void resetMenuSceneAnimations(final MenuScene pMenuScene) {
		final int menuItemCount = pMenuScene.getMenuItemCount();

		for (int i = 0; i < menuItemCount; i++) {
			final IMenuItem menuItem = pMenuScene.getMenuItem(i);

			final float x = this.getMenuItemX(pMenuScene, i);
			final float y = this.getMenuItemY(pMenuScene, i);
			this.onMenuItemPositionReset(pMenuScene, i, menuItem, x, y);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	protected float getMenuItemX(final MenuScene pMenuScene, final int pIndex) {
		final float menuSceneWidth = pMenuScene.getWidth();

		final IMenuItem menuItem = pMenuScene.getMenuItem(pIndex);
		final float menuItemWidth = menuItem.getWidth();

		if (this.mMenuItemOrientation == MenuItemOrientation.VERTICAL) {
			/* Determine horizontal position. */
			final float x;
			switch (this.mHorizontalAlign) {
			case LEFT:
				x = menuItemWidth * 0.5f;
				break;
			case CENTER:
				x = menuSceneWidth * 0.5f;
				break;
			case RIGHT:
				x = menuSceneWidth - (menuItemWidth * 0.5f);
				break;
			default:
				throw new IllegalArgumentException("Unexpected " + HorizontalAlign.class.getSimpleName() + " with value: '" + this.mHorizontalAlign + "'.");
			}
			return x + this.mOffsetX;
		} else {
			/* Prepare horizontal position */
			float baseX;
			switch (this.mHorizontalAlign) {
			case LEFT:
				baseX = 0;
				break;
			case CENTER:
				baseX = (0.5f * menuSceneWidth) - (this.mOverallWidth * 0.5f);
				break;
			case RIGHT:
				baseX = menuSceneWidth - this.mOverallWidth;
				break;
			default:
				throw new IllegalArgumentException("Unexpected " + HorizontalAlign.class.getSimpleName() + " with value: '" + this.mHorizontalAlign + "'.");
			}
			/* Determine horizontal position */
			final float x = baseX + (menuItemWidth * 0.5f) + (pIndex * (menuItemWidth + this.mMenuItemSpacing));

			return x + this.mOffsetX;
		}
	}

	protected float getMenuItemY(final MenuScene pMenuScene, final int pIndex) {
		final float menuSceneHeight = pMenuScene.getHeight();

		final IMenuItem menuItem = pMenuScene.getMenuItem(pIndex);
		final float menuItemHeight = menuItem.getHeight();

		if (this.mMenuItemOrientation == MenuItemOrientation.VERTICAL) {
			/* Prepare vertical position. */
			float baseY;
			switch (this.mVerticalAlign) {
			case TOP:
				baseY = menuSceneHeight;
				break;
			case CENTER:
				baseY = (0.5f * menuSceneHeight) + (this.mOverallHeight * 0.5f);
				break;
			case BOTTOM:
				baseY = this.mOverallHeight;
				break;
			default:
				throw new IllegalArgumentException("Unexpected " + VerticalAlign.class.getSimpleName() + " with value: '" + this.mVerticalAlign + "'.");
			}

			/* Determine vertical position. */
			final float y = baseY - (menuItemHeight * 0.5f) - (pIndex * (menuItemHeight + this.mMenuItemSpacing));

			return y + this.mOffsetY;
		} else {
			/* Determine vertical position. */
			final float y;
			switch (this.mVerticalAlign) {
			case TOP:
				y = menuSceneHeight - (menuItemHeight * 0.5f);
				break;
			case CENTER:
				y = menuSceneHeight * 0.5f;
				break;
			case BOTTOM:
				y = menuItemHeight * 0.5f;
				break;
			default:
				throw new IllegalArgumentException("Unexpected " + VerticalAlign.class.getSimpleName() + " with value: " + this.mVerticalAlign + "'.");
			}
			return y + this.mOffsetY;
		}
	}

	private void updateOverallDimension(final MenuScene pMenuScene) {
		final int menuItemCount = pMenuScene.getMenuItemCount();

		float overallHeight = 0;
		float overallWidth = 0;
		for (int i = menuItemCount - 1; i >= 0; i--) {
			final IMenuItem menuItem = pMenuScene.getMenuItem(i);
			if (this.mMenuItemOrientation == MenuItemOrientation.VERTICAL) {
				overallHeight += menuItem.getHeight();
				overallWidth = Math.max(overallWidth, menuItem.getWidth());
			} else {
				overallHeight = Math.max(overallHeight, menuItem.getHeight());
				overallWidth += menuItem.getWidth();
			}
		}

		if (this.mMenuItemOrientation == MenuItemOrientation.VERTICAL) {
			this.mOverallHeight = overallHeight + ((menuItemCount - 1) * this.mMenuItemSpacing);
			this.mOverallWidth = overallWidth;
		} else {
			this.mOverallHeight = overallHeight;
			this.mOverallWidth = overallWidth + ((menuItemCount - 1) * this.mMenuItemSpacing);
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	public enum MenuItemOrientation {
		VERTICAL, HORIZONTAL
	};
}
