package eu.davidea.samples.flexibleadapter.models;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.samples.flexibleadapter.ProgressBar;
import eu.davidea.samples.flexibleadapter.R;
import eu.davidea.samples.flexibleadapter.models.ProgressItem.ProgressViewHolder;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * @author Davide Steduto
 * @since 22/04/2016
 */
public class ProgressItem extends AbstractFlexibleItem<ProgressViewHolder> {

	@Override
	public boolean equals(Object o) {
		return this == o;//The default implementation
	}

	@Override
	public int getLayoutRes() {
		return R.layout.progress_bar;
	}

	@Override
	public ProgressViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
		return new ProgressViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
	}

	@Override
	public void bindViewHolder(FlexibleAdapter adapter, ProgressViewHolder holder, int position, List payloads) {
		if (payloads.size() == 0) {
			//Show loading animation
			holder.progressBar.setVisibility(View.VISIBLE);
		} else {
			//Show error reason or communicate "no more to load"
			holder.progressBar.setVisibility(View.INVISIBLE);
		}
	}

	public static class ProgressViewHolder extends FlexibleViewHolder {

		public ProgressBar progressBar;

		public ProgressViewHolder(View view, FlexibleAdapter adapter) {
			super(view, adapter);
			progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
		}
	}

}