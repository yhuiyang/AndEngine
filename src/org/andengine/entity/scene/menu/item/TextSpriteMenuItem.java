package org.andengine.entity.scene.menu.item;

import org.andengine.entity.text.Text;
import org.andengine.opengl.font.IFont;
import org.andengine.opengl.shader.ShaderProgram;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.DrawType;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 20:15:20 - 01.04.2010
 */
public class TextSpriteMenuItem extends SpriteMenuItem {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final int mID;
	private final Text mText;

	// ===========================================================
	// Constructors
	// ===========================================================

	public TextSpriteMenuItem(final int pID, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pID, pTextureRegion, pVertexBufferObjectManager);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final ShaderProgram pShaderProgram) {
		super(pID, pTextureRegion, pVertexBufferObjectManager, pShaderProgram);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pShaderProgram);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType) {
		super(pID, pTextureRegion, pVertexBufferObjectManager, pDrawType);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pDrawType);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType, final ShaderProgram pShaderProgram) {
		super(pID, pTextureRegion, pVertexBufferObjectManager, pDrawType, pShaderProgram);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pDrawType, pShaderProgram);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final float pWidth, final float pHeight, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pID, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final float pWidth, final float pHeight, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final ShaderProgram pShaderProgram) {
		super(pID, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager, pShaderProgram);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pShaderProgram);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final float pWidth, final float pHeight, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType) {
		super(pID, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager, pDrawType);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pDrawType);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	public TextSpriteMenuItem(final int pID, final float pWidth, final float pHeight, final IFont pFont, final CharSequence pText, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager, final DrawType pDrawType, final ShaderProgram pShaderProgram) {
		super(pID, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager, pDrawType, pShaderProgram);

		this.mID = pID;
		this.mText = new Text(0, 0, pFont, pText, pVertexBufferObjectManager, pDrawType, pShaderProgram);
		this.mText.setPosition((pTextureRegion.getWidth() - mText.getWidthScaled()) * 0.5f, (pTextureRegion.getHeight() - mText.getHeightScaled()) * 0.5f);
		this.attachChild(this.mText);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public int getID() {
		return this.mID;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void onSelected() {
		/* Nothing. */
	}

	@Override
	public void onUnselected() {
		/* Nothing. */
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
