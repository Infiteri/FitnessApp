import { useEffect, useState } from "react"
import ApiUtils from "../utils/ApiUtils";
import Exercise from "./Exercise";

export default function Exercises({ workout }) {
    const [exercises, setExercises] = useState([])

    useEffect(() => {
        async function loadExercises() {
            const res = await ApiUtils.Fetch("/api/v1/workout/exercises?workoutId=" + workout.id, {
                method: "GET"
            })

            const response = await res.json();
            setExercises(response);
        }

        loadExercises();
    }, [])

    return <div>
        {exercises.map((e, k) => <Exercise key={k} exercise={e} />)}
    </div>
}