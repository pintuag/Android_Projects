package android.example.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import static java.lang.Math.abs;

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("imag");
    private static final String TAG = GreenAdapter.class.getSimpleName();
    public static JSONObject fg=null;
    public static String hj="";
    // public static int count =0;
    // COMPLETED (3) Create a final private ListItemClickListener called mOnClickListener
    /*
     * An on-click handler that we've defined to make it easy for an Activity to interface with
     * our RecyclerView
     */
    final private ListItemClickListener mOnClickListener;

    /*
     * The number of ViewHolders that have been created. Typically, you can figure out how many
     * there should be by determining how many list items fit on your screen at once and add 2 to 4
     * to that number. That isn't the exact formula, but will give you an idea of how many
     * ViewHolders have been created to display any given RecyclerView.
     *
     * Here's some ASCII art to hopefully help you understand:
     *
     *    ViewHolders on screen:
     *
     *        *-----------------------------*
     *        |         ViewHolder index: 0 |
     *        *-----------------------------*
     *        |         ViewHolder index: 1 |
     *        *-----------------------------*
     *        |         ViewHolder index: 2 |
     *        *-----------------------------*
     *        |         ViewHolder index: 3 |
     *        *-----------------------------*
     *        |         ViewHolder index: 4 |
     *        *-----------------------------*
     *        |         ViewHolder index: 5 |
     *        *-----------------------------*
     *        |         ViewHolder index: 6 |
     *        *-----------------------------*
     *        |         ViewHolder index: 7 |
     *        *-----------------------------*
     *
     *    Extra ViewHolders (off screen)
     *
     *        *-----------------------------*
     *        |         ViewHolder index: 8 |
     *        *-----------------------------*
     *        |         ViewHolder index: 9 |
     *        *-----------------------------*
     *        |         ViewHolder index: 10|
     *        *-----------------------------*
     *        |         ViewHolder index: 11|
     *        *-----------------------------*
     *
     *    Total number of ViewHolders = 11
     */
    private static int viewHolderCount;
    private JSONArray fgh=new JSONArray();
    private int mNumberItems;
    private Context dh;
    private static Boolean dffff=true;
    public static  Bitmap[] ims=null;
    public static  String[] s=null;
    public static String s2=null;

@Override
public int getItemViewType(int position) {
    if (position==0)
        return 0;
    else
        return 1;


}
    // COMPLETED (1) Add an interface called ListItemClickListener
    // COMPLETED (2) Within that interface, define a void method called onListItemClick that takes an int as a parameter
    /**
     * The interface that receives onClick messages.
     */
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    // COMPLETED (4) Add a ListItemClickListener as a parameter to the constructor and store it in mOnClickListener
    /**
     * Constructor for GreenAdapter that accepts a number of items to display and the specification
     * for the ListItemClickListener.
     *
     * @param numberOfItems Number of items to display in list
     * @param listener Listener for list item clicks
     */
    public GreenAdapter(int numberOfItems, ListItemClickListener listener, Context con) {
        mNumberItems = numberOfItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        s =new String[10];

        ims=new Bitmap[10];


    dh=con;





    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.add;
        int wed = R.layout.disp;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view;

        try {
            String[] sdf = null;

        } catch (Exception e) {
            e.printStackTrace();

        }



        if (viewType==0)
            view = inflater.inflate(wed, viewGroup, shouldAttachToParentImmediately);
        else
        view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);


        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolderCount++;
        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: "
                + viewHolderCount);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            dffff = false;
            try {


            } catch (Exception e) {
                Log.e("wed", e.getMessage());
            }

        } else {

        }
    }
    /**
     * This method simply returns the number of items to display. It is used behind the scenes
     * to help layout our Views and for animations.
     *
     * @return The number of items available
     */
    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    // COMPLETED (5) Implement OnClickListener in the NumberViewHolder class
    /**
     * Cache of the children views for a list item.
     */
    class NumberViewHolder extends RecyclerView.ViewHolder
            implements OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        TextView t0;
        // Will display which ViewHolder is displaying this data
        TextView t1;
        TextView t2,ttime,day;
        ImageView i1;
        TextView tt;
        // Will display which ViewHolder is displaying this data
        TextView ws;
        TextView cname;
        TextView humid;
        ImageView i12;


        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link GreenAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder(View itemView) {
            super(itemView);



            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param listIndex Position of the item in the list
         */
        void bind(int listIndex) {

            // listItemNumberView.setText(String.valueOf(listIndex));
        }


        // COMPLETED (6) Override onClick, passing the clicked item's position (getAdapterPosition()) to mOnClickListener via its onListItemClick method
        /**
         * Called whenever a user clicks on an item in the list.
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int clickedPosition =getAdapterPosition() ;
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
    class NumberViewHolder1 extends RecyclerView.ViewHolder
            implements OnClickListener {

        // Will display the position in the list, ie 0 through getItemCount() - 1
        EditText e1;
        // Will display which ViewHolder is displaying this data
        TextView t1;

        ImageView i1;
        TextView tt;
        ImageView i0;


        /**
         * Constructor for our ViewHolder. Within this constructor, we get a reference to our
         * TextViews and set an onClickListener to listen for clicks. Those will be handled in the
         * onClick method below.
         * @param itemView The View that you inflated in
         *                 {@link GreenAdapter#onCreateViewHolder(ViewGroup, int)}
         */
        public NumberViewHolder1(View itemView) {
            super(itemView);

            t1 = (TextView) itemView.findViewById(R.id.t1);

            e1 = (EditText) itemView.findViewById(R.id.t1);
            t1 = (TextView) itemView.findViewById(R.id.t1);
            i0=(ImageView)itemView.findViewById(R.id.i0);
            i1=(ImageView)itemView.findViewById(R.id.i1);
            // COMPLETED (7) Call setOnClickListener on the View passed into the constructor (use 'this' as the OnClickListener)
            itemView.setOnClickListener(this);
        }

        /**
         * A method we wrote for convenience. This method will take an integer as input and
         * use that integer to display the appropriate text within a list item.
         * @param listIndex Position of the item in the list
         */
        void bind(int listIndex) {

            // listItemNumberView.setText(String.valueOf(listIndex));
        }


        // COMPLETED (6) Override onClick, passing the clicked item's position (getAdapterPosition()) to mOnClickListener via its onListItemClick method
        /**
         * Called whenever a user clicks on an item in the list.
         * @param v The View that was clicked
         */
        @Override
        public void onClick(View v) {
            int clickedPosition =getAdapterPosition() ;
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

    public class task extends AsyncTask<URL, Void, String[]> {
        TextView t34;
        int index=0;
        // COMPLETED (26) Override onPreExecute to set the loading indicator to visible
        public task(TextView t134, int pos){
            t34=t134;
            index=pos;

        }
        @Override

        protected void onPreExecute() {

        }

        @Override
        protected String[] doInBackground(URL... params) {
            String[] st;
            st =new String[50];
            URL url = params[0];

            String githubSearchResults = null;
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    InputStream in = urlConnection.getInputStream();

                    BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    StringBuilder responseStrBuilder = new StringBuilder();

                    String inputStr;

                    int i=0;
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseStrBuilder.append(inputStr);
                        st[i]=inputStr;
                        i++;
                    }
                    // JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("asdf",e.getMessage().toString());
            }
            s=st;
            return st;
        }

        @Override
        protected void onPostExecute(String[] Re) {
            //  TextView t2=(TextView)findViewById(R.id.t2);
            t34.setText(Re[index]);
        }
    }
    public class task2 extends AsyncTask<URL, Void, String[]> {
        TextView t34;
        int index=0;
        // COMPLETED (26) Override onPreExecute to set the loading indicator to visible
        public task2(TextView t134, int pos){
            t34=t134;
            index=pos;

        }
        @Override

        protected void onPreExecute() {

        }

        @Override
        protected String[] doInBackground(URL... params) {
            String[] st;
            st =new String[50];
            URL url = params[0];

            String githubSearchResults = null;
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    InputStream in = urlConnection.getInputStream();

                    BufferedReader streamReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                    StringBuilder responseStrBuilder = new StringBuilder();

                    String inputStr;

                    int i=0;
                    while ((inputStr = streamReader.readLine()) != null) {
                        responseStrBuilder.append(inputStr);
                        st[i]=inputStr;
                        i++;
                    }
                    // JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("asdf",e.getMessage().toString());
            }

            return st;
        }

        @Override
        protected void onPostExecute(String[] Re) {
            //  TextView t2=(TextView)findViewById(R.id.t2);
            t34.setText(Re[index]);
        }
    }
    public class taskimage extends AsyncTask<URL, Void, Bitmap> {
        ImageView t34;
        int index=0;
        // COMPLETED (26) Override onPreExecute to set the loading indicator to visible
        public taskimage(ImageView t134, int pos){
            t34=t134;
            index=pos;

        }
        @Override

        protected void onPreExecute() {
  /*          try
            {
                t34.setImageBitmap(ims[index]);
            }
            catch (Exception e)
            {

            }
*/
        }

        @Override
        protected Bitmap doInBackground(URL... params) {
            Bitmap st=null;

            URL url = params[0];


            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {

                    InputStream in = urlConnection.getInputStream();

                    st= BitmapFactory.decodeStream(in);

                    String inputStr;

                    int i=0;

                    // JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                Log.e("asdfimag",e.getMessage().toString());
            }
//        ims[index]=st;
            return st;
        }

        @Override
        protected void onPostExecute(Bitmap Re) {
            //  TextView t2=(TextView)findViewById(R.id.t2);
            // t34.setText(Re[index]);
            //ims[index]=Re;



        }
    }


}
