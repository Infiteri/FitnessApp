package org.example.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.models.User;
import org.example.models.Workout;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SqlUtils
{
        public static User GetUserByPhoneNumber(String phone)
        {
                HttpURLConnection conn = null;
                try
                {
                        conn = ApiUtils.FetchApi("/api/v1/user/phoneNumber?phoneNumber=" + phone, ApiUtils.RequestMethod.GET, null);

                        if (conn.getResponseCode() != 200) return null;

                        var result = ApiUtils.ReadApiResponse(conn);
                        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();

                        User user = new User();
                        user.SetId(jsonObject.get("id").getAsInt());
                        user.SetPhoneNumber(jsonObject.get("phoneNumber").getAsString());
                        user.SetName(jsonObject.get("name").getAsString());
                        return user;
                } catch (IOException e)
                {
                        e.printStackTrace();
                } finally
                {
                        if (conn != null) conn.disconnect();
                }

                return null;
        }

        public static List<Workout> GetWorkoutsByUserId(int id)
        {
                HttpURLConnection conn = null;
                try
                {
                        conn = ApiUtils.FetchApi("/api/v1/workout/all?userId=" + id, ApiUtils.RequestMethod.GET, null);

                        if (conn.getResponseCode() != 200) return null;

                        var result = ApiUtils.ReadApiResponse(conn);
                        JsonArray array = JsonParser.parseString(result).getAsJsonArray();

                        List<Workout> workouts = new ArrayList<>();

                        for (JsonElement obj : array)
                        {
                                JsonObject json = obj.getAsJsonObject();

                                Workout w = new Workout();
                                w.SetId(json.get("id").getAsInt());
                                w.SetWorkoutDateTime(LocalDateTime.parse(json.get("workoutDateTime").getAsString()));
                                w.SetName(json.get("name").getAsString());

                                // todo: Store something about the user ?

                                workouts.add(w);
                        }

                        return workouts;
                } catch (IOException e)
                {
                        e.printStackTrace();
                } finally
                {
                        if (conn != null) conn.disconnect();
                }

                return null;
        }

        public static boolean PostLoginUser(String phone, String password)
        {
                HttpURLConnection conn = null;
                try
                {
                        conn = ApiUtils.FetchApi("/api/v1/user/login?phoneNumber=" + phone + "&password=" + password, ApiUtils.RequestMethod.POST, null);

                        if (conn.getResponseCode() != 200)
                        {
                                return false;
                        }

                } catch (IOException e)
                {
                        e.printStackTrace();
                } finally
                {
                        if (conn != null) conn.disconnect();
                }

                return true;
        }

        public static boolean PostCreateUser(JsonObject userData)
        {
                HttpURLConnection conn = null;
                try
                {
                        conn = ApiUtils.FetchApi("/api/v1/user", ApiUtils.RequestMethod.POST, userData);

                        if (conn.getResponseCode() != 200) return false;
                } catch (IOException e)
                {
                        e.printStackTrace();
                } finally
                {
                        if (conn != null) conn.disconnect();
                }

                return true;
        }

}
