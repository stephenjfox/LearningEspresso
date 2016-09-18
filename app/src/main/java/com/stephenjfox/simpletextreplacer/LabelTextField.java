package com.stephenjfox.simpletextreplacer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Stephen on 9/18/2016.
 */
public class LabelTextField extends RelativeLayout {

  private TextView mLabelText;
  private EditText mEditText;

  public LabelTextField(final Context context, final AttributeSet attributeSet) {
    this(context, attributeSet, 0);
  }

  public LabelTextField(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initControlProperties(context);
    applyAttributeSet(attrs);
  }

  private void initControlProperties(final Context context) {
    final LayoutInflater inflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    inflater.inflate(R.layout.label_text_field, this);

    mLabelText = (TextView) findViewById(R.id.label_text);
    mEditText = (EditText) findViewById(R.id.text_field);
  }

  private void applyAttributeSet(final AttributeSet attributesEt) {
    final TypedArray typedArray = getContext()
        .obtainStyledAttributes(attributesEt, R.styleable.LabelTextField);

    String labelString = null;

    // assign our properties
    for (int i = 0; i < typedArray.getIndexCount(); i++) {
      int attribute = typedArray.getIndex(i); // specially indexed attribute

      if (attribute == R.styleable.LabelTextField_label) {
        labelString = typedArray.getString(attribute);
      }
    }

    if (labelString == null) labelString = "Input text";

    mLabelText.setText(labelString);

    typedArray.recycle(); // recommended call
  }

  /**
   * @return the text contained in this LabelTextField's inner "EditText" or the empty string,
   * iff the inner field isn't initialized
   */
  public String getText() {
    if (mEditText == null) {
      return "";
    }
    return mEditText.getText().toString();
  }
}
