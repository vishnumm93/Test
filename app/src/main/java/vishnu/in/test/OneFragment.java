package vishnu.in.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment {

    private List<Songs> songsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SongsAdapter mAdapter;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        recyclerView = (RecyclerView)view. findViewById(R.id.recycler_view);

        mAdapter = new SongsAdapter(songsList,getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareSongData();

        return view;
    }

    private void prepareSongData() {
        Songs song = new Songs("I'M FALLING LOVE WITH U", "18 HOURS AGO", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.","https://placeholdit.imgix.net/~text?txtsize=33&txt=150%C3%97150&w=150&h=150");
        songsList.add(song);

        song = new Songs("I'M FALLING LOVE WITH U", "18 HOURS AGO", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.","https://placeholdit.imgix.net/~text?txtsize=33&txt=150%C3%97150&w=150&h=150");
        songsList.add(song);

        song = new Songs("I'M FALLING LOVE WITH U", "18 HOURS AGO", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.","https://placeholdit.imgix.net/~text?txtsize=33&txt=150%C3%97150&w=150&h=150");
        songsList.add(song);

        song = new Songs("I'M FALLING LOVE WITH U", "18 HOURS AGO", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.","https://placeholdit.imgix.net/~text?txtsize=33&txt=150%C3%97150&w=150&h=150");
        songsList.add(song);

        song = new Songs("I'M FALLING LOVE WITH U", "18 HOURS AGO", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.","https://placeholdit.imgix.net/~text?txtsize=33&txt=150%C3%97150&w=150&h=150");
        songsList.add(song);

        mAdapter.notifyDataSetChanged();
    }

}
