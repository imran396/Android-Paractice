package bd.gov.teachers.teacherportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProfileAdapter extends ArrayAdapter {
    private List list = new ArrayList();

    public ProfileAdapter(Context context, int resourses) {
        super(context, resourses);
    }

    public void add(Profile profile) {
        super.add(profile);
        list.add(profile);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProfileHolder profileHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.activity_profile_row, parent, false);
            profileHolder = new ProfileHolder();
            profileHolder.text_name = (TextView) row.findViewById(R.id.textViewName);
            profileHolder.text_email = (TextView) row.findViewById(R.id.textViewEmail);
            row.setTag(profileHolder);
        } else {
            profileHolder = (ProfileHolder) row.getTag();
        }

        Profile profile = (Profile) this.getItem(position);
        profileHolder.text_name.setText(profile.getName());
        profileHolder.text_email.setText(profile.getEmail());

        return row;
    }

    static class ProfileHolder {
        TextView text_name, text_email;
    }
}
