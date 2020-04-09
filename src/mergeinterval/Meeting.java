package mergeinterval;
class Meeting {
  int start;
  int end;

  public Meeting(int start, int end) {
    this.start = start;
    this.end = end;
  }

@Override
public String toString() {
	return "Meeting [start=" + start + ", end=" + end + "]";
}
  
  
}