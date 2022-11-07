import "./Button.css";
export const Button = (props) => {
  return (
    <button className="btn-primary" onClick={props.onClick}>
      {props.text}
    </button>
  );
};
