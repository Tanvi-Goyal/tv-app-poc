package com.embibe.app.embibetvapp.custom

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.view.View.OnFocusChangeListener
import android.view.View.OnHoverListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager


class CustomRecyclerView : RecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    private val firstPosition: Int
        get() {
            val layoutManager = layoutManager
            if (layoutManager is StaggeredGridLayoutManager) {
                var firstVisibleItems: IntArray? = null
                firstVisibleItems =
                    layoutManager.findFirstCompletelyVisibleItemPositions(firstVisibleItems)
                return firstVisibleItems!![0]
            } else if (layoutManager is LinearLayoutManager) {
                return layoutManager.findFirstCompletelyVisibleItemPosition()
            }
            return -1
        }

    private val lastPosition: Int
        get() {
            val layoutManager = layoutManager
            if (layoutManager is StaggeredGridLayoutManager) {
                var lastVisibleItems: IntArray? = null
                lastVisibleItems =
                    layoutManager.findLastCompletelyVisibleItemPositions(lastVisibleItems)
                return lastVisibleItems!![0]
            } else if (layoutManager is LinearLayoutManager) {
                return layoutManager.findLastCompletelyVisibleItemPosition()
            }
            return -1
        }


    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return ev.action == MotionEvent.ACTION_MOVE || super.dispatchTouchEvent(ev)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        val dx = this.getChildAt(0).width
        val focusView = this.focusedChild
        if (focusView != null) {
            when (event.keyCode) {
                KeyEvent.KEYCODE_DPAD_RIGHT -> return if (event.action == KeyEvent.ACTION_UP) {
                    true
                } else {
                    val rightView =
                        FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_RIGHT)
                    if (rightView != null) {
                        rightView.requestFocusFromTouch()
                        true
                    } else {
                        this.smoothScrollBy(dx, 0)
                        true
                    }
                }
                KeyEvent.KEYCODE_DPAD_LEFT -> {
                    val leftView =
                        FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_LEFT)
                    return if (event.action == KeyEvent.ACTION_UP) {
                        true
                    } else {
                        if (leftView != null) {
                            leftView.requestFocusFromTouch()
                            true
                        } else {
                            this.smoothScrollBy(-dx, 0)
                            true
                        }
                    }
                }
            }
        }
        return super.dispatchKeyEvent(event)
    }

    override fun onScrolled(dx: Int, dy: Int) {
        super.onScrolled(dx, dy)
        val focusView = this.focusedChild
        if (focusView != null) {
            if (dx > 0) {
                val rightView =
                    FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_RIGHT)
                rightView?.requestFocusFromTouch()
            } else {
                val rightView =
                    FocusFinder.getInstance().findNextFocus(this, focusView, View.FOCUS_LEFT)
                rightView?.requestFocusFromTouch()
            }
        }

    }


    fun isLastItemVisible(lineNum: Int, allItemNum: Int): Boolean {
        val position = lastPosition
        val layoutManager = layoutManager
        if (layoutManager is StaggeredGridLayoutManager) {
            return position >= allItemNum - lineNum
        } else if (layoutManager is LinearLayoutManager) {
            return allItemNum - 1 == position
        }
        return false
    }


    abstract class CustomAdapter<T>(private var mContext: Context, private var mData: List<T>?) :
        RecyclerView.Adapter<ViewHolder>() {
        private val mInflater: LayoutInflater = LayoutInflater.from(mContext)


        private var mListener: OnItemClickListener? = null

        protected abstract val count: Int

        interface OnItemClickListener {
            fun onItemClick(view: View, position: Int)

            fun onItemLongClick(view: View, position: Int)
        }

        fun setOnItemClickListener(listener: OnItemClickListener) {
            mListener = listener
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = mInflater.inflate(onSetItemLayout(), parent, false)
            return onSetViewHolder(view)
        }

        protected abstract fun onSetViewHolder(view: View): ViewHolder


        protected abstract fun onSetItemLayout(): Int

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            onSetItemData(holder, position)
            holder.itemView.isFocusable = true
            holder.itemView.setOnHoverListener(OnHoverListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_HOVER_ENTER -> {
                        val recyclerView = holder.itemView.parent as RecyclerView
                        val location = IntArray(2)
                        recyclerView.getLocationOnScreen(location)
                        val x = location[0]
                        if (recyclerView.scrollState == SCROLL_STATE_IDLE) {
                            if (event.rawX > recyclerView.width + x || event.rawX < x) {
                                return@OnHoverListener true
                            }
                            v.requestFocusFromTouch()
                            v.requestFocus()
                            focusStatus(v, position)
                        }
                    }
                    MotionEvent.ACTION_HOVER_MOVE -> {
                    }
                    MotionEvent.ACTION_HOVER_EXIT -> normalStatus(v, position)
                }
                false
            })

            holder.itemView.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    focusStatus(v, position)
                } else {
                    normalStatus(v, position)
                }
            }

            if (mListener != null) {
                holder.itemView.setOnClickListener { v -> mListener!!.onItemClick(v, position) }

                holder.itemView.setOnLongClickListener { v ->
                    mListener!!.onItemLongClick(v, position)
                    true
                }
            }
        }

        protected abstract fun onSetItemData(viewHolder: ViewHolder, position: Int)

        private fun focusStatus(itemView: View?, position: Int) {
            if (itemView == null) {
                return
            }
            onItemFocus(itemView, position)
        }

        protected abstract fun onItemFocus(itemView: View, position: Int)

        private fun normalStatus(itemView: View?, position: Int) {
            if (itemView == null) {
                return
            }
            onItemGetNormal(itemView, position)

        }

        protected abstract fun onItemGetNormal(itemView: View, position: Int)

        override fun getItemCount(): Int {
            return if (mData != null) count else 0
        }
    }
}
