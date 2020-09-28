import {User} from './user';
import {DiagnosticCenter} from './diagnostic-center';
import {TestDetails} from './test-details';

export class Appointment {
  appointmentId: number;
  user: User;
  diagnosticCenter: DiagnosticCenter;
  test: TestDetails;
  approved: boolean;
  timestamp: string;
}
