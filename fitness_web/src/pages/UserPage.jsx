import { useEffect, useState } from "react"
import ApiUtils from "../utils/ApiUtils";
import Utils from "../utils/Utils";
import Workouts from "../components/Workouts";
import WorkoutDetail from "../components/WorkoutDetail";
import Button from "../components/Button";

export default function UserPage() {
    const [user, setUser] = useState(null)
    const [workouts, setWorkouts] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)
    const [detailedWorkout, setDetailedWorkout] = useState(null);
    const [showModal, setShowModal] = useState(false);
    const [newWorkoutName, setNewWorkoutName] = useState("");
    const [newWorkoutDate, setNewWorkoutDate] = useState("");

    useEffect(() => {
        async function fetchUser() {
            let phoneNumber = localStorage.getItem("phoneNumber");
            if (!phoneNumber) {
                setError("No phone number found. Please login.");
                setLoading(false);
                return;
            }

            if (!Utils.ValidatePhoneNumber(phoneNumber)) {
                setError("Invalid phone number.");
                setLoading(false);
                return;
            }

            phoneNumber = Utils.FormatPhoneNumber(phoneNumber);

            try {
                const res = await ApiUtils.Fetch("/api/v1/user/phoneNumber?phoneNumber=" + (phoneNumber), { method: "GET" });

                if (res.ok) {
                    const data = await res.json();
                    const workouts = await ApiUtils.Fetch("/api/v1/workout/all?userId=" + data.id, { method: "GET" })
                    const workoutData = await workouts.json();

                    setWorkouts(workoutData)
                    setUser(data)
                } else {
                    setError("User not found.");
                }
            } catch (err) {
                console.error(err);
                setError("An error occurred while fetching user data.");
            } finally {
                setLoading(false);
            }
        }

        fetchUser();
    }, []);

    const handleClick = (w) => {
        setDetailedWorkout(w);
    }

    const onWorkoutUpdate = (updatedWorkout) => {
        setWorkouts((prev) =>
            prev.map((w) => (w.id === updatedWorkout.id ? updatedWorkout : w))
        );
    }

    const onWorkoutDelete = (deleted) => {
        setWorkouts((prev) =>
            prev.filter((w) => w.id !== deleted.id)
        );

        if (detailedWorkout?.id === deleted.id) {
            setDetailedWorkout(null);
        }
    }

    const onAddClicked = () => {
        setShowModal(true);
    }

    const onModalClose = () => {
        setShowModal(false);
        setNewWorkoutName("");
        setNewWorkoutDate("");
    }

    const onModalConfirm = async () => {
        if (!newWorkoutName || !newWorkoutDate) {
            alert("Please enter both a name and a date.");
            return;
        }

        const body = {
            name: newWorkoutName,
            workoutDateTime: newWorkoutDate,
            user: {id: user.id}
        };

        try {
            const res = await ApiUtils.Fetch("/api/v1/workout", {
                method: "POST",
                body: JSON.stringify(body)
            });

            if (res.ok) {
                const createdWorkout = await res.json();
                setWorkouts([...workouts, createdWorkout]);
                onModalClose();
            } else {
            }
        } catch (err) {
            console.error(err);
        }
    }

    if (loading) return <p className="text-4xl text-white">Loading...</p>;
    if (error) return <p style={{ color: "red" }}>{error}</p>;

    return (
        <div className="flex flex-row gap-4">
            <div className="flex-1 pl-4">
                <Workouts workouts={workouts} onClick={handleClick} />

                <Button
                    text={"Add"}
                    style="mt-5 bg-green-500 font-bold text-xl w-30 py-1"
                    onClick={onAddClicked}
                />
            </div>

            <div className="flex-1 pr-4">
                <WorkoutDetail
                    workout={detailedWorkout}
                    onWorkoutUpdate={onWorkoutUpdate}
                    onWorkoutDelete={onWorkoutDelete}
                    userId={user.id}
                />
            </div>

            {showModal && (
                <div className="fixed inset-0 bg-black bg-opacity-60 flex items-center justify-center">
                    <div className="bg-white rounded-2xl p-6 w-96 shadow-lg flex flex-col gap-4">
                        <h2 className="text-2xl font-bold text-center mb-2">Add Workout</h2>

                        <input
                            type="text"
                            placeholder="Workout name..."
                            value={newWorkoutName}
                            onChange={(e) => setNewWorkoutName(e.target.value)}
                            className="border border-gray-400 rounded p-2"
                        />

                        <input
                            type="datetime-local"
                            value={newWorkoutDate}
                            onChange={(e) => setNewWorkoutDate(e.target.value)}
                            className="border border-gray-400 rounded p-2"
                        />

                        <div className="flex justify-between mt-4">
                            <button
                                className="bg-green-500 text-white font-bold px-4 py-2 rounded"
                                onClick={onModalConfirm}
                            >
                                Confirm
                            </button>

                            <button
                                className="bg-gray-400 text-white font-bold px-4 py-2 rounded"
                                onClick={onModalClose}
                            >
                                Cancel
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}
