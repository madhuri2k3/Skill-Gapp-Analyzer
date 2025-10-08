import { useState } from "react";

export default function JobForm({ onSubmit }) {
  const [jobId, setJobId] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    if (jobId) onSubmit(jobId);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Job ID:
        <input
          type="number"
          value={jobId}
          onChange={(e) => setJobId(e.target.value)}
        />
      </label>
      <button type="submit">Submit Job</button>
    </form>
  );
}
