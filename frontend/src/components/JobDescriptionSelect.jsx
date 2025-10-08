import React, { useEffect, useState } from "react";
import Select from "react-select";
import { getJobs } from "../services/api";

const JobDescriptionSelect = ({ onJobSelect }) => {
  const [jobs, setJobs] = useState([]);

  useEffect(() => {
    getJobs().then(setJobs).catch(console.error);
  }, []);

  const options = jobs.map((job) => ({ value: job.id, label: job.jobTitle }));

  return <Select options={options} onChange={(selected) => onJobSelect(selected.value)} />;
};

export default JobDescriptionSelect;
