package org.andengine.entity.modifier;

import java.util.LinkedList;
import java.util.Queue;

import org.andengine.entity.IEntity;
import org.andengine.util.modifier.ease.EaseLinear;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * CascadingAlphaModifier will modify the alpha value for the entity and all its
 * child entities.
 * 
 * @author yhyang <yhuiyang@gmail.com>
 */

public class CascadingAlphaModifier extends AlphaModifier {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	private Queue<IEntity> mQ = new LinkedList<IEntity>();

	// ===========================================================
	// Constructors
	// ===========================================================
	public CascadingAlphaModifier(final float pDuration,
			final float pFromAlpha, final float pToAlpha) {
		this(pDuration, pFromAlpha, pToAlpha, null, EaseLinear.getInstance());
	}

	public CascadingAlphaModifier(final float pDuration,
			final float pFromAlpha, final float pToAlpha,
			final IEaseFunction pEaseFunction) {
		this(pDuration, pFromAlpha, pToAlpha, null, pEaseFunction);
	}

	public CascadingAlphaModifier(final float pDuration,
			final float pFromAlpha, final float pToAlpha,
			final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener,
				EaseLinear.getInstance());
	}

	public CascadingAlphaModifier(final float pDuration,
			final float pFromAlpha, final float pToAlpha,
			final IEntityModifierListener pEntityModifierListener,
			final IEaseFunction pEaseFunction) {
		super(pDuration, pFromAlpha, pToAlpha, pEntityModifierListener,
				pEaseFunction);
	}

	protected CascadingAlphaModifier(
			final CascadingAlphaModifier pCascadingAlphaModifier) {
		super(pCascadingAlphaModifier);
	}

	@Override
	public CascadingAlphaModifier deepCopy() {
		return new CascadingAlphaModifier(this);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================
	@Override
	protected void onSetInitialValue(final IEntity pEntity, final float pAlpha) {
		setAlphaByBreadthFirstTraversal(pEntity, pAlpha);
	}

	@Override
	protected void onSetValue(final IEntity pEntity,
			final float pPercentageDone, final float pAlpha) {
		setAlphaByBreadthFirstTraversal(pEntity, pAlpha);
	}

	// ===========================================================
	// Methods
	// ===========================================================
	private void setAlphaByBreadthFirstTraversal(final IEntity pEntity,
			final float pAlpha) {
		IEntity entity;
		int entityCount;
		mQ.clear();
		mQ.offer(pEntity);
		while (mQ.peek() != null) {
			entity = mQ.poll();
			if (entity != null)
				entity.setAlpha(pAlpha);
			entityCount = entity.getChildCount();
			for (int entityIndex = 0; entityIndex < entityCount; entityIndex++)
				mQ.offer(entity.getChildByIndex(entityIndex));
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
