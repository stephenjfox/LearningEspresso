package com.stephenjfox.simpletextreplacer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Custom Component: an {@link EditText} with an associated label (defined as a {@link TextView})
 *
 * Created by Stephen on 9/18/2016.
 */
public class LabeledEditText extends RelativeLayout {

  private TextView mLabelText;
  private EditText mEditText;

  public LabeledEditText(final Context context, final AttributeSet attributeSet) {
    this(context, attributeSet, 0);
  }

  public LabeledEditText(final Context context, final AttributeSet attrs, final int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initControlProperties(context);
    applyAttributeSet(attrs);
  }

  /**
   * Bind the inner-elements of this compenent
   *
   * @param context to acquire a {@link LayoutInflater} from
   */
  private void initControlProperties(final Context context) {
    final LayoutInflater inflater = (LayoutInflater)
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    inflater.inflate(R.layout.labeled_edit_text, this);

    mLabelText = (TextView) findViewById(R.id.label_text);
    mEditText = (EditText) findViewById(R.id.text_field);
  }

  /**
   * Iterate through the attributes this component is initialized with
   *
   * @param attributeSet bundle of attributes defined on our XML inflation
   */
  private void applyAttributeSet(final AttributeSet attributeSet) {
    final TypedArray typedArray = getContext()
        .obtainStyledAttributes(attributeSet, R.styleable.LabeledEditText);

    String labelString = null;

    // assign our properties
    for (int i = 0; i < typedArray.getIndexCount(); i++) {
      int attribute = typedArray.getIndex(i); // specially indexed attribute

      if (attribute == R.styleable.LabeledEditText_label) {
        labelString = typedArray.getString(attribute);
      }
    }

    // sane defaults
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
